var PROTO_FILE_PATH='D:\\work\\IdeaProjects\\NettyStudy\\src\\idl\\protobuf\\Student.proto';
var grpc=require('grpc');
var grpcService=grpc.load(PROTO_FILE_PATH).com.m51das.proto;

var client=new grpcService.StudentService('localhost:50051',grpc.credentials.createInsecure());
client.getRealNameByUsername({username:'lisi'},function (error,respData) {
    console.log(respData);
});