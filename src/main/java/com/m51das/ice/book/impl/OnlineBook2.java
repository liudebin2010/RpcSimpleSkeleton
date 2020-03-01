package com.m51das.ice.book.impl;

import Ice.Communicator;
import Ice.Current;
import Ice.ObjectAdapter;
import IceBox.Service;
import com.m51das.ice.book.sv.Message;
import com.m51das.ice.book.sv._OnlineBookDisp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnlineBook2 extends _OnlineBookDisp implements Service {

    private Logger logger= LoggerFactory.getLogger(OnlineBook2.class);
    private ObjectAdapter _adapter;

    @Override
    public void start(String name, Communicator communicator, String[] args) {
        // 创建objectAdapter,这里和service同名
        _adapter=communicator.createObjectAdapter(name);
        // 创建servant并激活
        Ice.Object object=this;
        _adapter.add(object,communicator.stringToIdentity(name));
        _adapter.activate();
        logger.info(name+" started");
    }

    @Override
    public void stop() {
        logger.info(this._adapter.getName()," stoped");
        // 销毁adapter
        _adapter.destroy();
    }

    @Override
    public Message bookTick(Message msg, Current __current) {
        logger.info("bookTick to call."+logger.getClass().getName());
        logger.debug("bookTick called "+msg.content);
        return msg;
    }
}
