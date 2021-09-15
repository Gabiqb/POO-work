package main;

public class DATA {
	private   String URL = "jdbc:mysql://localhost:3306/";
	private   String DB_NAME = "orders";
	private   String USER = "root";
	private  String PASSWORD = "Dumbass132!";
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getDB_NAME() {
		return DB_NAME;
	}
	public void setDB_NAME(String dB_NAME) {
		DB_NAME = dB_NAME;
	}
	public String getUSER() {
		return USER;
	}
	public void setUSER(String uSER) {
		USER = uSER;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}
