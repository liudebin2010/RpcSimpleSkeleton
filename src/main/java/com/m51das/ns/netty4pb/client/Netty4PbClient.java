package com.m51das.ns.netty4pb.client;

import com.m51das.ns.socket.client.SimpleSocketClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Netty4PbClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new Netty4PbClientInitializer());
            ChannelFuture channelFuture=bootstrap.connect("localhost",8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup .shutdownGracefully();
        }

    }
}
