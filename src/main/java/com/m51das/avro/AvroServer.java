package com.m51das.avro;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.m51das.avro.svimpl.MailImpl;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.netty.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;
import com.m51das.avro.generated.Mail;

public class AvroServer {

    private static Server server;

    private static void startServer() throws IOException {
        server = new NettyServer(new SpecificResponder(Mail.class, new MailImpl()), new InetSocketAddress(65111));
        // the server implements the Mail protocol (MailImpl)
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Starting server");
        // usually this would be another app, but for simplicity
        startServer();
        System.out.println("Server started");
    }
}
