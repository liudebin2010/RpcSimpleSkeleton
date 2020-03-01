package com.m51das.ice;

import com.m51das.ice.sv.MyServicePrx;
import com.m51das.ice.sv.MyServicePrxHelper;

public class IceClient {
    public static void main(String[] args) {
        int status=0;
        Ice.Communicator ic=null;
        try {
            // 初始化通信器
            ic=Ice.Util.initialize(args);
            // 传入远程服务单元的名称、网络协议、IP及端口，构造一个Proxy对象
            Ice.ObjectPrx base=ic.stringToProxy("MyService:default -p 1000");
            // 通过checkedCast向下转型，获取MyService接口的远程，并同时检测根据传入的名称获取服务单元是否OnlineBook的代理接口
            MyServicePrx prx= MyServicePrxHelper.checkedCast(base);
            if (prx==null){
                throw new Error("invalid proxy");
            }
            // 调用服务方法
            String rt=prx.hellow();
            System.out.println(rt);
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
