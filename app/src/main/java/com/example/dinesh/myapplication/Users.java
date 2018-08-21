package com.example.dinesh.myapplication;

import java.util.HashMap;

public class Users {

    private String uid;
    private String name;
    public Users(){
    }

    public Users(String uid , String name){
            this.uid = uid;
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

}
