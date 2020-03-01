package com.m51das.ns.netty4pb.client.handler;

import com.m51das.ns.netty4pb.pbm.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class Netty4PbClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int ranInt=new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage=null;
        if (ranInt==0){
            myMessage=MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder().setName("wangwu").setAge(36).setAddress("dl").build())
                    .build();
        }else if (ranInt==1){
            myMessage=MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder().setName("erha").setAge(3).build())
                    .build();
        }else {
            myMessage=MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder().setName("heimao").setCity("df").build())
                    .build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
