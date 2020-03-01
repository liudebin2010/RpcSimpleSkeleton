package com.m51das.ns.http;

import com.m51das.ns.http.handler.SimpleHttpServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class SimpleHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline=ch.pipeline();
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new SimpleHttpServerHandler());
    }
}
