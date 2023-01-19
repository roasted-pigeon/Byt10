package com.control;

import com.company.LoginData;
import com.company.Session;

import java.util.ArrayList;

public class SessionController {
    public ArrayList<Session> activeSessions = new ArrayList<>();

    public int startSession(LoginData login){
        Session tempSession = new Session(login);
        for (Session session:activeSessions) if (session.matches(tempSession)) return 1;
        activeSessions.add(tempSession);
        return -1;
    }

    public void validateSessions(){
        for (Session session:activeSessions) if (session.isExpired()) session.invalidate();
        for (Session session:activeSessions) if (!session.isValid()) activeSessions.remove(session);
    }
}
