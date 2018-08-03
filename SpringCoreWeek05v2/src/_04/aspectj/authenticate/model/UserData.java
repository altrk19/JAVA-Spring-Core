package _04.aspectj.authenticate.model;

public class UserData {
	private String userName;
	private String password;
	private boolean locked;
	private int tryCount;
	
	public UserData() {
		super();
	}

	public UserData(String userName, String password, boolean locked, int tryCount) {
		super();
		this.userName = userName;
		this.password = password;
		this.locked = locked;
		this.tryCount = tryCount;
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
	
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public int getTryCount() {
		return tryCount;
	}
	
	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	
	
	
}
