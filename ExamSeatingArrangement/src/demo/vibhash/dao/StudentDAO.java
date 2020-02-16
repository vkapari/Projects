/**
 * 
 */
package demo.vibhash.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.vibhash.model.Room;

/**
 * @author vkapari
 *
 */
public class StudentDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public StudentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
            
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO STUDENT (STUDENT_ID, STUDENT_NAME, STUDENT_CLASS, ROOM_DESC) VALUES (?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, room.getRoomId());
        statement.setLong(2, room.getNoOfRows());
        statement.setLong(3, room.getNoOfColumns());
        statement.setString(4, room.getDescription());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Room> listAllRooms() throws SQLException {
        List<Room> listRoom = new ArrayList<Room>();
         
        String sql = "SELECT ROOM_ID, NO_OF_ROWS, NO_OF_COLUMNS, ROOM_DESC FROM ROOM";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String roomId = resultSet.getString("ROOM_ID");
            Integer noOfRows = resultSet.getInt("NO_OF_ROWS");
            Integer noOfColumns = resultSet.getInt("NO_OF_COLUMNS");
            String roomDesc = resultSet.getString("ROOM_DESC");
             
            Room room = new Room(roomId, noOfRows, noOfColumns, roomDesc);
            listRoom.add(room);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listRoom;
    }
     
    public boolean deleteRoom(String roomId) throws SQLException {
        String sql = "DELETE FROM ROOM WHERE ROOM_ID = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, roomId);
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateRoom(Room room) throws SQLException {
    	
        String sql = "UPDATE ROOM SET NO_OF_ROWS = ?, NO_OF_COLUMNS = ?, ROOM_DESC = ?";
        sql += " WHERE ROOM_ID = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, room.getNoOfRows());
        statement.setLong(2, room.getNoOfColumns());
        statement.setString(3, room.getDescription());
        statement.setString(4, room.getRoomId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Room getRoom(String roomId) throws SQLException {
        Room room = null;
        String sql = "SELECT ROOM_ID, NO_OF_ROWS, NO_OF_COLUMNS, ROOM_DESC FROM ROOM WHERE ROOM_ID = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, roomId);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            Integer noOfRows = resultSet.getInt("NO_OF_ROWS");
            Integer noOfColumns = resultSet.getInt("NO_OF_COLUMNS");
            String roomDesc = resultSet.getString("ROOM_DESC");
            room = new Room(roomId, noOfRows, noOfColumns, roomDesc);
        }
         
        resultSet.close();
        statement.close();
         
        return room;
    }
    

}
