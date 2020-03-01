var service=require('.\proto\Student_grpc_pb');
var message=require('.\proto/Student_pb');

var grpc=require('grpc');

var server=new grpc.Server();
server.addService(service.StudentServiceService,{
    getRealNameByUsername: getRealNameByUsername,
    getStudentsByage: getStudentsByage,
    getStudentsWrapperByAges: getStudentsWrapperByAges,
    biTalk:biTalk
});

server.bind('localhost:50051',grpc.ServerCredentials.createInsecure());
server.start();

function getRealNameByUsername(call,callback) {
    console.log("request:"+call.request.getUsername());

    var myResponse=new message.MyResponse();
    myResponse.setRealname('赵六');
    callback(null,myResponse)
}

function getStudentsByage() {

}

function getStudentsWrapperByAges() {

}

function biTalk() {

}