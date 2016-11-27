
public class Student {
	private Account account;

	public Student(String userName, String password) {
		account = new Account();
		account.setUserName(userName);
		account.setPassword(password);
	}

	public Student() {
		this("", "");
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Student [" + account + "]";
	}
}
