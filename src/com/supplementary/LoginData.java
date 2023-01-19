package com.supplementary;

import java.util.Calendar;
import java.util.Date;

public class LoginData {
    private String login;
    private String password;
    private int status;
    private int loginAttempts;
    private Date expiresDateTime;

    public LoginData(String login, String password){
        this.login=login;
        this.password=password;
        this.status=1;//got to figure out different states of loginData yet
        this.loginAttempts=0;
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.add(Calendar.MONTH, 1);
        this.expiresDateTime= tempCalendar.getTime();
    }

    public boolean matches(LoginData loginData){
        if (this.login.equals(loginData.getLogin())&&this.password.equals(loginData.getPassword())){
            return true;
        }else if (this.login.equals(loginData.getLogin())&&!this.password.equals(loginData.getPassword())){
            if(loginAttempts<3) {
                this.loginAttempts+=1;
                return false;
            }else{
                this.status=0;
                return false;
            }
        }
        return false;
    }

    public boolean isExpired(){
        return Calendar.getInstance().getTime().after(this.expiresDateTime);
    }

    public void invalidateLogin(){this.status=0;}

    public boolean isValid(){return this.status==1;}

    private String getLogin(){
        return this.login;
    }

    private String getPassword(){
        return this.password;
    }
}
