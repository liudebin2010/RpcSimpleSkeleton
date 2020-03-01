var PROTO_FILE_PATH='D:\\work\\IdeaProjects\\NettyStudy\\src\\idl\\protobuf\\Student.proto';
var grpc=require('grpc');
var grpcService=grpc.load(PROTO_FILE_PATH).com.m51das.proto;

var server=new grpc.Server();
server.addService(grpcService.StudentService.service,{
    getRealNameByUsername: getRealNameByUsername,
    getStudentsByage: getStudentsByage,
    getStudentsWrapperByAges: getStudentsWrapperByAges,
    biTalk:biTalk
});

server.bind("localhost:50051",grpc.ServerCredentials.createInsecure());
server.start();

function getRealNameByUsername(call,callback) {
    console.log("call:"+call);
    callback(null,{realname:'张三'})
}

function getStudentsByage() {

}

function getStudentsWrapperByAges() {

}

function biTalk() {

}