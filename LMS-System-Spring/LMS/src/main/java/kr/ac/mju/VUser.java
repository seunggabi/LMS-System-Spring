package kr.ac.mju;

public class VUser {
	public static enum ELoginInfo {success, idError, passwordError};
	
	private ELoginInfo eLoginInfo;
	private String ID;
	private String pw;
	private String name;
	private String type;
	
	public ELoginInfo geteLoginInfo() {return eLoginInfo;}
	public void seteLoginInfo(ELoginInfo eLoginInfo) {this.eLoginInfo = eLoginInfo;}
	public String getID() {return ID;}
	public void setId(String ID) {this.ID = ID;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
}