package com.m51das.thrift;

import com.m51das.thrift.generated.Person;
import com.m51das.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport=new TFramedTransport(new TSocket("localhost",8899),600);// 与服务器端呼应，数据传输方式：以、frame为单位进行传输，非阻塞式服务中使用
        TProtocol protocol=new TCompactProtocol(transport);// 与服务器端呼应,传输格式：压缩格式
        PersonService.Client client=new PersonService.Client(protocol);

        try{
            transport.open();

            Person person=client.getPersonByUsername("zhangsan");
            System.out.println(person.toString());

            System.out.println("========================");

            Person person1=new Person();
            person1.setUsername("zhaoliu");
            person1.setAge(34);
            person1.setMarried(false);

            client.savePerson(person);
        }catch(Exception exception){
            throw new RuntimeException(exception.getMessage(),exception);
        }finally {
            transport.close();
        }

    }
}
