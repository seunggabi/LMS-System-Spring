package kr.ac.mju;

public class CCourse extends CEntity {
	private String name;
	private String professorID;
	private String professorName;
	private boolean isRegister;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getProfessorID() {return professorID;}
	public void setProfessorID(String professorID) {this.professorID = professorID;}
	public String getProfessorName() {return professorName;}
	public void setProfessorName(String professorName) {this.professorName = professorName;}
	public boolean getIsRegister() {return isRegister;}
	public void setRegister(boolean isRegister) {this.isRegister = isRegister;}
	
	public CCourse(String name)
	{
		this.name = name;
	}
	public CCourse(String id, String name, String professorID) {
		this.ID = id;
		this.name = name;
		this.professorID = professorID;
	}
	public CCourse(String id, String name, String professorID, String professorName) {
		this.ID = id;
		this.name = name;
		this.professorID = professorID;
		this.professorName = professorName;
	}
}
