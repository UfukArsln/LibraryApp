package pck;

public class LoginUserInfo {
	
	private static LoginUserInfo instance;
    private int userid;

    private LoginUserInfo() {}

    public static LoginUserInfo getInstance() {
        if (instance == null) {
            instance = new LoginUserInfo();
        }
        return instance;
    }

    public void setUserID(int userid) {
        this.userid = userid;
    }

    public int getUserID() {
        return userid;
    }

}
