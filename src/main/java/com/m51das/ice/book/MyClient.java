package com.m51das.ice.book;

import com.m51das.ice.book.sv.Message;
import com.m51das.ice.book.sv.OnlineBookPrx;
import com.m51das.ice.book.sv.OnlineBookPrxHelper;
import com.m51das.ice.sv.MyServicePrx;
import com.m51das.ice.sv.MyServicePrxHelper;

public class MyClient {
    public static void main(String[] args) {
        int status=0;
        Ice.Communicator ic=null;
        try {
            // 初始化通信器
            ic=Ice.Util.initialize(args);
            // 传入远程服务单元的名称、网络协议、IP及端口，构造一个Proxy对象
            Ice.ObjectPrx base=ic.stringToProxy("OnlineBook:default -p 10001");
            // 通过checkedCast向下转型，获取MyService接口的远程，并同时检测根据传入的名称获取服务单元是否OnlineBook的代理接口
            OnlineBookPrx prx= OnlineBookPrxHelper.checkedCast(base);
            if (prx==null){
                throw new Error("invalid proxy");
            }
            Message msg=new Message();
            msg.name="Mr Liu";
            msg.type=3;
            msg.price=1000;
            msg.valid=true;
            msg.content="asdfasdf";

            // 调用服务方法
            Message message=prx.bookTick(msg);
            System.out.println(message.content);
        } catch (Exception e){
            e.printStackTrace();
            status=1;
        } finally {
            if (ic!=null){
                ic.destroy();
            }
        }
        System.exit(status);
    }
}
