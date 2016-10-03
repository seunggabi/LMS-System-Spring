package kr.ac.mju;

public class CUser extends CEntity
{
	private String pw;
	private String name;
	private String type;

	public CUser(){}
	public CUser(String id, String pw, String name, String type) {
		this.ID = id;
		this.pw = pw;
		this.name = name;
		this.type = type;
	}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
}
