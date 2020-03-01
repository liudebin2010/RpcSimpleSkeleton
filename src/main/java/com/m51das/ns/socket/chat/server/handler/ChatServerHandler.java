package com.m51das.ns.socket.chat.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    // 保存channel
    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.forEach(ch->{
            if (channel!=ch){
                ch.writeAndFlush(channel.remoteAddress()+"发送消息："+msg+"\n");
            } else {
                ch.writeAndFlush("【自己】："+msg+"\n");
            }
        });
    }

    /**
     * 新连接建立
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("【服务器】："+channel.remoteAddress()+"加入\n");
        channelGroup.add(channel);
    }

    /**
     * 连接断开
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("【服务器】："+channel.remoteAddress()+"离开\n");
        //若不使用ChannelGroup，需要在此处移除channel
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+"上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+"下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
