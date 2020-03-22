package com.luqmansen.test;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "first", eager = true)
public class First {

    public First(){
        System.out.println("Test");
    }

    public String getMessage(){
        return "Test";
    }
}
