
public class Account {
	private String userName;
	private String password;
	private long userID = 0;
	static long userIDs = 1001;
	
	public Account(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.userID = userIDs++;
	}
	public Account() {
		this("", "");
	}
	public long getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userName=" + userName + ", userID=" + userID;
	}
	
}
