package demo.vibhash.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.vibhash.dao.StudentDAO;
import demo.vibhash.model.Room;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet(urlPatterns = { "/student"})
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControllerServlet() {
        super();
    }

    private StudentDAO studentDAO;
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        String serverTimeZone = "?serverTimezone=UTC";
        studentDAO = new StudentDAO(jdbcURL+serverTimeZone, jdbcUsername, jdbcPassword);
 
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
System.out.println("requestUri=> "+requestUri);
        String actionName = request.getParameter("action");
System.out.println("actionName=> "+actionName);

        try {
            switch (actionName) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
                    break;
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	
	private void listStudents(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Room> listRooms = studentDAO.listAllRooms();
		        request.setAttribute("listRooms", listRooms);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/roomview/roomlist.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/roomview/roomform.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String roomId = request.getParameter("roomId");
		        Room existingRoom = studentDAO.getRoom(roomId);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/roomview/roomform.jsp");
		        request.setAttribute("room", existingRoom);
		        dispatcher.forward(request, response);

		    }

		    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String roomId = request.getParameter("roomId");
		        Integer noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
		        Integer noOfColumns = Integer.parseInt(request.getParameter("noOfColumns"));
		        String description = request.getParameter("roomDesc");
		        
		        Room newRoom = new Room(roomId, noOfRows, noOfColumns, description);
		        studentDAO.addRoom(newRoom);
		        response.sendRedirect(request.getRequestURI()+"?action=list");
		    }

		    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	String roomId = request.getParameter("roomId");
		        Integer noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
		        Integer noOfColumns = Integer.parseInt(request.getParameter("noOfColumns"));
		        String description = request.getParameter("roomDesc");

		        Room room = new Room(roomId, noOfRows, noOfColumns, description);
		        studentDAO.updateRoom(room);
		        response.sendRedirect(request.getRequestURI()+"?action=list");
		    }

		    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String roomId = request.getParameter("roomId");
		        studentDAO.deleteRoom(roomId);
		        response.sendRedirect(request.getRequestURI()+"?action=list");
		    }

}
