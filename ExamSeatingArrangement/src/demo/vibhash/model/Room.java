/**
 * 
 */
package demo.vibhash.model;

/**
 * @author vkapari
 *
 */
public class Room {

	private String roomId;
	private Integer noOfRows;
	private Integer noOfColumns;
	private String description;
	
	public Room() {
		super();
	}
	
	public Room(String roomId, Integer noOfRows, Integer noOfColumns, String description) {
		super();
		this.roomId = roomId;
		this.noOfRows = noOfRows;
		this.noOfColumns = noOfColumns;
		this.description = description;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomCapacity() {
		return noOfRows*noOfColumns;
	}

	public Integer getNoOfRows() {
		return noOfRows;
	}

	public void setNoOfRows(Integer noOfRows) {
		this.noOfRows = noOfRows;
	}

	public Integer getNoOfColumns() {
		return noOfColumns;
	}

	public void setNoOfColumns(Integer noOfColumns) {
		this.noOfColumns = noOfColumns;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
