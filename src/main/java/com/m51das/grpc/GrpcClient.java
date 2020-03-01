package com.m51das.grpc;

import com.m51das.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",50051).usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub= StudentServiceGrpc.newBlockingStub(managedChannel);
        StudentServiceGrpc.StudentServiceStub stub=StudentServiceGrpc.newStub(managedChannel);


        MyResponse myResponse=blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
        System.out.println(myResponse.getRealname());

        System.out.println("---------------------------------");
        Iterator<StudentResponse> iter=blockingStub.getStudentByAge(StudentRequest.newBuilder().setAge(20).build());

        while (iter.hasNext()){
            StudentResponse studentResponse=iter.next();
            System.out.println(studentResponse.getName()+","+studentResponse.getAge()+","+studentResponse.getCity());
        }

        System.out.println("---------------------------------");

        StreamObserver<StudentResponseList> studentResponseListdStreamObserver=new StreamObserver<StudentResponseList>(){
            @Override
            public void onNext(StudentResponseList value){
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("**********************");
                });
            }
            @Override
            public void onError(Throwable t){
                System.out.println(t.getMessage());
            }
            @Override
            public void onCompleted(){
                System.out.println("completed");
            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver=stub.getStudentsWrapperByAges(studentResponseListdStreamObserver);
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(50).build());

        studentRequestStreamObserver.onCompleted();
    }
}
