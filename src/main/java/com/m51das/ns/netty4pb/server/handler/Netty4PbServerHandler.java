package com.m51das.ns.netty4pb.server.handler;

import com.m51das.ns.netty4pb.pbm.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Netty4PbServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dataType=msg.getDataType();
        if (dataType== MyDataInfo.MyMessage.DataType.PersonType){
            MyDataInfo.Person person=msg.getPerson();
            System.out.println(person.toString());
        } else if (dataType== MyDataInfo.MyMessage.DataType.DogType){
            MyDataInfo.Dog dog=msg.getDog();
            System.out.println(dog.toString());
        } else {
            MyDataInfo.Cat cat=msg.getCat();
            System.out.println(cat.toString());
        }
        System.out.println(msg.toString());
    }
}
