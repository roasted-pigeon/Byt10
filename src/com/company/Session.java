package com.company;

import java.util.Calendar;
import java.util.Date;

public class Session {
    private int status;
    private Date establishedDateTime;
    private Date expiresDateTime;
    private LoginData loginData;

    public Session(LoginData loginData){
        this.status = 1;
        this.establishedDateTime = Calendar.getInstance().getTime();
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.add(Calendar.MINUTE, 15);
        this.expiresDateTime = tempCalendar.getTime();
    }

    public void invalidate(){
        this.status=0;
    }

    public boolean isExpired(){
        return this.expiresDateTime.before(Calendar.getInstance().getTime());
    }

    public boolean isValid(){
        return this.status==1;
    }

    public boolean matches(Session session){
        if(this.status==1&&this.loginData.matches(session.loginData)&&this.expiresDateTime.after(session.establishedDateTime)) return true;
        return false;
    }
}
