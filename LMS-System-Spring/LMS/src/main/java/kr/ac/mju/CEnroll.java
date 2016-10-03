package kr.ac.mju;

public class CEnroll extends CEntity {
	private int no;
	private String courseID;
	private String grade;
	private String studentName;
	private String courseName;

	public String getCourseName() {return courseName;}
	public void setCourseName(String courseName) {this.courseName = courseName;}
	public String getStudentName() {return studentName;}
	public void setStudentName(String studentName) {this.studentName = studentName;}
	public int getNo() {return no;}
	public void setNo(int no) {this.no = no;}
	public String getCourseID() {return courseID;}
	public void setCourseID(String course_id) {this.courseID = course_id;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	public CEnroll() {}
	
	public CEnroll(String studentID, String courseID) {
		this.ID = studentID;
		this.courseID = courseID;
		this.grade = "-";
	}
	public CEnroll(String studentID, String courseID, String courseName, String grade) {
		this.ID = studentID;
		this.courseID = courseID;
		this.courseName = courseName;
		this.grade = grade;
	}
	public CEnroll(String studentID, String studentName, String courseID, String courseName, String grade) {
		this.ID = studentID;
		this.studentName = studentName;
		this.courseID = courseID;
		this.courseName = courseName;
		this.grade = grade;
	}
}
