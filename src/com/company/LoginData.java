package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LoginData {
    private String login;
    private String password;
    private int status;
    private int loginAttempts;
    private Date expiresDateTime;
    private User user;
    private ArrayList<Session> sessions = new ArrayList<>();

    public LoginData(String login, String password, User user){
        this.login=login;
        this.password=password;
        this.status=1;//got to figure out different states of loginData yet
        this.loginAttempts=0;
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.add(Calendar.MONTH, 1);
        this.expiresDateTime= tempCalendar.getTime();
        this.user=user;
    }

    public boolean checkDataValidity(LoginData loginData){
        if (this.login.equals(loginData.getLogin())&&this.password.equals(loginData.getPassword())){
            return true;
        }else {
            initiateCountdown(loginData);
        }
        return false;
    }

    public boolean initiateCountdown(LoginData loginData){
        if (this.login.equals(loginData.getLogin())&&!this.password.equals(loginData.getPassword())) {
            if (loginAttempts < 3) {
                this.loginAttempts += 1;
                return false;
            } else {
                this.invalidateData();
                return false;
            }
        }
        return false;
    }

    public boolean isExpired(){
        return Calendar.getInstance().getTime().after(this.expiresDateTime);
    }

    public void invalidateData(){this.status=0;}

    public boolean isValid(){return this.status==1;}

    private String getLogin(){
        return this.login;
    }

    private String getPassword(){
        return this.password;
    }
}
