package com.m51das.grpc;

import com.m51das.grpc.svimpl.StudentServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    private Server server;
     private void start()throws IOException{
         int port=50051;
         this.server= ServerBuilder.forPort(port).addService(new StudentServiceImpl()).build().start();
         System.out.println("server started!");
         Runtime.getRuntime().addShutdownHook(new Thread(()->{
             System.out.println("close jvm");
             GrpcServer.this.stop();
         }));
         System.out.println("exec here!");
     }

     private void stop(){
         if (null!=this.server){
             this.server.shutdown();
         }
     }

     private void awaitTerination() throws InterruptedException {
         if (null!=this.server){
             this.server.awaitTermination();
         }
     }

    public static void main(String[] args) throws Exception{
        GrpcServer server=new GrpcServer();
        server.start();
        server.awaitTerination();
    }
}
