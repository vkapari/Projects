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

import demo.vibhash.dao.RoomDAO;
import demo.vibhash.model.Room;

/**
 * Servlet implementation class RoomControllerServlet
 */
@WebServlet(urlPatterns = { "/room"})
public class RoomControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RoomDAO roomDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        String serverTimeZone = "?serverTimezone=UTC";
        roomDAO = new RoomDAO(jdbcURL+serverTimeZone, jdbcUsername, jdbcPassword);
 
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
                    insertRoom(request, response);
                    break;
                case "delete":
                    deleteRoom(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateRoom(request, response);
                    break;
                default:
                    listRoom(request, response);
                    break;
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	private void listRoom(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Room> listRooms = roomDAO.listAllRooms();
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
		        Room existingRoom = roomDAO.getRoom(roomId);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/roomview/roomform.jsp");
		        request.setAttribute("room", existingRoom);
		        dispatcher.forward(request, response);

		    }

		    private void insertRoom(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String roomId = request.getParameter("roomId");
		        Integer noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
		        Integer noOfColumns = Integer.parseInt(request.getParameter("noOfColumns"));
		        String description = request.getParameter("roomDesc");
		        
		        Room newRoom = new Room(roomId, noOfRows, noOfColumns, description);
		        roomDAO.addRoom(newRoom);
		        response.sendRedirect(request.getRequestURI()+"?action=list");
		    }

		    private void updateRoom(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	String roomId = request.getParameter("roomId");
		        Integer noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
		        Integer noOfColumns = Integer.parseInt(request.getParameter("noOfColumns"));
		        String description = request.getParameter("roomDesc");

		        Room room = new Room(roomId, noOfRows, noOfColumns, description);
		        roomDAO.updateRoom(room);
		        response.sendRedirect(request.getRequestURI()+"?action=list");
		    }

		    private void deleteRoom(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String roomId = request.getParameter("roomId");
		        roomDAO.deleteRoom(roomId);
		        response.sendRedirect(request.getRequestURI()+"?action=list");
		    }

}
