package com.m51das.ice.sms.impl;

import Ice.Communicator;
import Ice.Current;
import Ice.Logger;
import Ice.ObjectAdapter;
import IceBox.Service;
import com.m51das.ice.book.sv.Message;
import com.m51das.ice.book.sv.OnlineBookPrx;
import com.m51das.ice.book.sv.OnlineBookPrxHelper;
import com.m51das.ice.sms.sv._SMSServiceDisp;

public class SMSService2 extends _SMSServiceDisp implements Service {
    private ObjectAdapter _adapter;
    private Logger log;

    @Override
    public void start(String name, Communicator communicator, String[] args) {
        this.log=communicator.getLogger().cloneWithPrefix(name);
        // 创建objectAdapter,这里和service同名
        _adapter=communicator.createObjectAdapter(name);
        // 创建servant并激活
        Ice.Object object=this;
        _adapter.add(object,communicator.stringToIdentity(name));
        _adapter.activate();
        log.trace("control "," started");
    }

    @Override
    public void stop() {
        log.trace("control "," stoped");
        _adapter.destroy();
    }

    @Override
    public void sendSMS(String msg, Current __current) {
        if (msg.startsWith("book")){
            try{
                Ice.ObjectPrx base=_adapter.getCommunicator().stringToProxy("OnlineBook:default -p 10001");
                OnlineBookPrx onlineBook= OnlineBookPrxHelper.checkedCast(base);
                Message bookMessage=new Message();
                bookMessage.name="Mr Wang";
                bookMessage.type=3;
                bookMessage.price=102;
                bookMessage.valid=true;
                bookMessage.content="35tgdfsfsd";
                Message tmpMsg=onlineBook.bookTick(bookMessage);
                System.out.println(tmpMsg.toString());
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("send msg "+msg);
    }
}
