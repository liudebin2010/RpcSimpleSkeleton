package com.m51das.avro;

import com.m51das.avro.generated.Mail;
import com.m51das.avro.generated.Message;
import org.apache.avro.ipc.netty.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.util.Utf8;
import java.io.IOException;
import java.net.InetSocketAddress;

public class AvroClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Usage: <to> <from> <body>");
            System.exit(1);
        }

        NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(65111));
        // client code - attach to the server and send a message
        Mail proxy = (Mail) SpecificRequestor.getClient(Mail.class, client);
        System.out.println("Client built, got proxy");

        // fill in the Message record and send it
        Message message = new Message();
        message.setTo(new Utf8(args[0]));
        message.setFrom(new Utf8(args[1]));
        message.setBody(new Utf8(args[2]));
        System.out.println("Calling proxy.send with message:  " + message.toString());
        System.out.println("Result: " + proxy.send(message));
        client.close();

    }
}
