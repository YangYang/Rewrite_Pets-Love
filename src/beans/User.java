package beans;

import cn.bmob.v3.BmobObject;

/**
 * Created by yangyang on 2017/1/17.
 */
public class User extends BmobObject{
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userSex;

    public User(String userEmail,String userPassword,String userName,String userSex){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
    }
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
