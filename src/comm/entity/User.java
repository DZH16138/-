package comm.entity;

public class User {
    private String sid;
    private String Username;
    private String Password;
    private String Right;

    public String getSid() {
        return sid;
    }

    public String getUsername() {
        return Username;
    }

    public String getRight() {
        return Right;
    }

    public String getPassword() {
        return Password;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setRight(String right) {
        Right = right;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
