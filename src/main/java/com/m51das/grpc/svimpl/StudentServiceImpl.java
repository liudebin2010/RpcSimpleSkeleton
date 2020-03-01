package com.m51das.grpc.svimpl;

import com.m51das.grpc.generated.*;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
        System.out.println("accept client info："+request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentByAge(StudentRequest request, io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
        System.out.println("accept client info："+request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(30).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四").setAge(20).setCity("天津").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(40).setCity("成都").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("赵六").setAge(50).setCity("深圳").build());

        responseObserver.onCompleted();
    }

    @Override
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentsWrapperByAges(io.grpc.stub.StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>(){
            @Override
            public void onNext(StudentRequest value){
                System.out.println("onNext:"+value.getAge());
            }
            @Override
            public void onError(Throwable t){
                System.out.println(t.getMessage());
            }
            @Override
            public void onCompleted(){
                StudentResponse studentResponse=StudentResponse.newBuilder().setName("王开").setAge(20).setCity("夏门").build();
                StudentResponse studentResponse2=StudentResponse.newBuilder().setName("线明").setAge(30).setCity("无锡").build();

                StudentResponseList studentResponseList=StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponse2).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }
}
