package com.control;

import com.supplementary.LoginData;

import java.util.ArrayList;

public class LoginController {
    private ArrayList<LoginData> loginData = new ArrayList<>();
    private SessionController sessionController = new SessionController();

    public void addLoginData(LoginData loginData){
        this.loginData.add(loginData);
    }

    public void removeLoginData(LoginData loginData){
        for (LoginData login:this.loginData){
            if (login.matches(loginData)) this.loginData.remove(login);
        }
    }

    public boolean checkLoginData(LoginData loginData){
        for (LoginData login:this.loginData){
            if (login.matches(loginData)&&!login.isExpired()&&login.isValid()) return true;
        }
        return false;
    }

    public void logIn(LoginData loginData){
        if(checkLoginData(loginData)) sessionController.startSession(loginData);
    }
}
