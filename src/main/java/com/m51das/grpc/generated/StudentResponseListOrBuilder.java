// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.m51das.grpc.generated;

public interface StudentResponseListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.m51das.proto.StudentResponseList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.m51das.proto.StudentResponse studentResponse = 1;</code>
   */
  java.util.List<com.m51das.grpc.generated.StudentResponse> 
      getStudentResponseList();
  /**
   * <code>repeated .com.m51das.proto.StudentResponse studentResponse = 1;</code>
   */
  com.m51das.grpc.generated.StudentResponse getStudentResponse(int index);
  /**
   * <code>repeated .com.m51das.proto.StudentResponse studentResponse = 1;</code>
   */
  int getStudentResponseCount();
  /**
   * <code>repeated .com.m51das.proto.StudentResponse studentResponse = 1;</code>
   */
  java.util.List<? extends com.m51das.grpc.generated.StudentResponseOrBuilder> 
      getStudentResponseOrBuilderList();
  /**
   * <code>repeated .com.m51das.proto.StudentResponse studentResponse = 1;</code>
   */
  com.m51das.grpc.generated.StudentResponseOrBuilder getStudentResponseOrBuilder(
      int index);
}