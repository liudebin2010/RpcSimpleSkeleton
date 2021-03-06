package com.m51das.avro.svimpl;

import com.m51das.avro.generated.Mail;
import com.m51das.avro.generated.Message;
import org.apache.avro.util.Utf8;

public class MailImpl implements Mail {
    // in this simple example just return details of the message
    public Utf8 send(Message message) {
        System.out.println("Sending message");
        return new Utf8("Sending message to " + message.getTo().toString()
                + " from " + message.getFrom().toString()
                + " with body " + message.getBody().toString());
    }
}
