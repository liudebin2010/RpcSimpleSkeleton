package com.m51das.ice.sv.impl;

import Ice.Current;
import com.m51das.ice.sv._MyServiceDisp;

public class MyServiceImpl extends _MyServiceDisp {
    @Override
    public String hellow(Current __current) {
        return "Hello world";
    }
}
