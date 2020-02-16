/**
 * 
 */
package demo.vibhash.model;

/**
 * @author vkapari
 *
 */
public class Student {

	private Integer studentId;
	private String studentName;
	private String studentClass;
	private String studentSem;
	private String studentSeatNo;
	private String studentRoomNo;
	private String studentAttendence;
			
	public Student() {
		super();
	}
	
	public Student(Integer studentId, String studentName, String studentClass, String studentSem, String studentSeatNo,
			String studentRoomNo, String studentAttendence) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentSem = studentSem;
		this.studentSeatNo = studentSeatNo;
		this.studentRoomNo = studentRoomNo;
		this.studentAttendence = studentAttendence;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentSem() {
		return studentSem;
	}
	public void setStudentSem(String studentSem) {
		this.studentSem = studentSem;
	}
	public String getStudentSeatNo() {
		return studentSeatNo;
	}
	public void setStudentSeatNo(String studentSeatNo) {
		this.studentSeatNo = studentSeatNo;
	}
	public String getStudentRoomNo() {
		return studentRoomNo;
	}
	public void setStudentRoomNo(String studentRoomNo) {
		this.studentRoomNo = studentRoomNo;
	}
	public String getStudentAttendence() {
		return studentAttendence;
	}
	public void setStudentAttendence(String studentAttendence) {
		this.studentAttendence = studentAttendence;
	}
		
}
