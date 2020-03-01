# -*- coding:utf-8 -*-
# server:java
__author__='author'

from py.thrift.generated import PersonService
from py.thrift.generated import ttypes

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol
import sys

reload(sys)
sys.setdefaultencoding('utf8')

try:
    tSocket=TSocket.TSocket('localhost',8899)
    tSocket.setTimeout(600)

    transport=TTransport.TFramedTransport(tSocket)
    protocol=TCompactProtocol.TCompactProtocol(transport)
    client=PersonService.Client(protocol)

    transport.open()

    person=client.getPersonByUsername("张三")

     print person.username
     print person.age
     print person.married

     print '-------------'

    newPerson=ttypes.Person()
    newPerson.username='lisi'
    newPerson.age=34
    newPerson.married=True

    client.savePerson(newPerson)

    transport.close()
exception Thrift.TException,tx:
    print '%s'%tx.message

