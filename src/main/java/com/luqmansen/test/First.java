package com.luqmansen.test;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "first", eager = true)
public class First {

    public String getMessage(){
        return "Yaay !!!";
    }
}
