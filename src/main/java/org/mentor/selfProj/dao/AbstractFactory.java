package org.mentor.selfProj.dao;

public class AbstractFactory{


    public Factory getFactory(String typeOfFactory){
        switch(typeOfFactory){
            case "UserDaoFactory": return new UserDaoFactory();
            default: return null;
        }
    }
}
