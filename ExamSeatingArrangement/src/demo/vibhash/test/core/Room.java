package demo.vibhash.test.core;

public class Room {

	private String roomId;
	private Integer noOfRows;
	private Integer noOfColumns;
	
	public Room() {
		super();
	}
	
	public Room(String roomId, Integer noOfRows, Integer noOfColumns) {
		super();
		this.roomId = roomId;
		this.noOfRows = noOfRows;
		this.noOfColumns = noOfColumns;
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

	/*public void setRoomCapacity(Integer noOfRows, Integer noOfColumns) {
		this.roomCapacity = noOfRows*noOfColumns;
	}*/

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
	
}
