package com.m51das.ns.socket.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.UUID;

public class SimpleSocketServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+","+msg);

        ctx.channel().writeAndFlush("from server:"+ UUID.randomUUID());
        ctx.writeAndFlush("sdf");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
