package demo.chatbot.main;

import java.io.File;

import demo.chatbot.Bot;
import demo.chatbot.Chat;
import demo.chatbot.History;
import demo.chatbot.MagicBooleans;
import demo.chatbot.MagicStrings;
import demo.chatbot.utils.IOUtils;

public class DemoChatBot {


    private static final boolean TRACE_MODE = false;
    static String botName = "jarvis";
 
    public static void main(String[] args) {
    	startChat();
    }
 
    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        System.out.println("resourcesPath=> "+resourcesPath);
        return resourcesPath;
    }

    private static void startChat(){
        try {
            String resourcesPath = getResourcesPath();
            System.out.println(resourcesPath);
            MagicBooleans.trace_mode = TRACE_MODE;
            Bot bot = new Bot("jarvis", resourcesPath);
            Chat chatSession = new Chat(bot);
            bot.brain.nodeStats();
            String textLine = "";
 
            while(true) {
                System.out.print("Human : ");
                textLine = IOUtils.readInputTextLine();
                if ((textLine == null) || (textLine.length() < 1))
                    textLine = MagicStrings.null_input;
                if (textLine.equals("q")) {
                    System.exit(0);
                } else if (textLine.equals("wq")) {
                    bot.writeQuit();
                    System.exit(0);
                } else if (textLine.equalsIgnoreCase("quit")) {
                    bot.writeQuit();
                    System.exit(0);
                } else {
                    String request = textLine;
                    if (MagicBooleans.trace_mode)
                        System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
                    String response = chatSession.multisentenceRespond(request);
                    while (response.contains("&lt;"))
                        response = response.replace("&lt;", "<");
                    while (response.contains("&gt;"))
                        response = response.replace("&gt;", ">");
                    System.out.println("Jarvis : " + response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't find about it, Sorry!!");
        }
    }

}
