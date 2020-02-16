package demo.vibhash.test.core;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class DemoSeatAllocationAlgo {

	public static void main(String[] args) {

		
		
		
		
		
		
		
	}

	public void arrangeStudents(){
		//Map<> arragnementMap = new HashMap<>();
		List<Student> studentList = getStudents();
		Map<String, Room> roomMap = getRooms();
		Room room = roomMap.get("R1");
		int capacity = room.getRoomCapacity();
		int noOfStudents = studentList.size();
		int noOfRows = room.getNoOfRows();
		int noOfColumns = room.getNoOfColumns();
		int[][] place = new int[room.getNoOfRows()][room.getNoOfColumns()];
		if(noOfStudents <= capacity){
			for(int i = 0; i < noOfColumns; i++){
				for(int j = 0; j < noOfRows; j++){
//					place[i][j];
				}	
			}
		}
		
		
	}
	public List<Student> getStudents() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Student s1 = new Student("101", "Name1", "BSCIT", "VI");
		Student s2 = new Student("102", "Name2", "BSCIT", "VI");
		Student s3 = new Student("103", "Name3", "BSCIT", "VI");
		Student s4 = new Student("104", "Name4", "BSCIT", "VI");
		Student s5 = new Student("105", "Name5", "BSCIT", "VI");
		Student s6 = new Student("106", "Name6", "BSCIT", "VI");
		Student s7 = new Student("107", "Name7", "BSCIT", "VI");
		Student s8 = new Student("108", "Name8", "BSCIT", "VI");
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
		studentList.add(s8);
		
		return studentList;
	}
	
	public Map<String, Room> getRooms() {
		Map<String, Room> roomMap = new HashMap<String, Room>();
		
		ArrayList<Room> roomList = new ArrayList<Room>();
		Room r1 = new Room("R1", 5, 5);
		Room r2 = new Room("R2", 5, 6);
		Room r3 = new Room("R3", 4, 5);
		Room r4 = new Room("R4", 6, 6);
		/*Room r5 = new Room("R5", 5, 5);
		Room r6 = new Room("R6", 5, 5);
		Room r7 = new Room("R7", 5, 5);
		Room r8 = new Room("R8", 5, 5);*/
		roomList.add(r1);
		roomList.add(r2);
		roomList.add(r3);
		roomList.add(r4);
		/*roomList.add(r5);
		roomList.add(r6);
		roomList.add(r7);
		roomList.add(r8);*/
		
		roomMap.put("R1", r1);
		roomMap.put("R2", r1);
		roomMap.put("R3", r1);
		roomMap.put("R4", r1);
		
		return roomMap;
	}
}
