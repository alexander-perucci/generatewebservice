Automatic WebService Generation
==================

Automatic WebService Generation is a Java tool that allows you to generate a Web service automatically.
The generation is very fast and allow you to get the stub of the service to be generated, allowing developers to concentrate only in the implementation of the service.
Generate the stub is really simple and automatic generation is based on the creation of a configuration file and execution of a simple command from your terminal system. 

## Getting Started

### Downloading Automatic WebService Generation

Automatic WebService Generation can be downloaded [here](https://github.com/prednaxela/generatewebservice/archive/master.zip)

### Dependencies

Automatic WebService Generation use:

 1. Java [version 1.7]
 2. Velocity [version 1.7]
 3. Commons-io [version 2.4]
 4. Commons-cli [version 1.2]
 5. JAX-WS RI [version installed in the system]

## Usage

Generate a Web Server using this command line:

<pre>
java -jar generateWebService.jar [-p <arg>] [-wsdl <arg>]

Where

     -p <arg>      Properties file configuration
     -wsdl <arg>   Wsdl
</pre>

**Note: after generation of the web service by opening the project with an IDE such as Eclipse or NetBeans you will notice an error in the class that implements the service (*Impl). This is caught because in this class you will need to implement all abstract methods of the generated service interface.**

## Example

In this project is present a Test Class that generates a Calculator Web Service that exposes two operations: multiply and sum.

### calculator.properties

<pre>
  #parameters for Application generation
  webservice.path=./
  webservice.name=Calculator
  
  #parameters for artifact: pom
  pom.groupId=com.alexanderperucci.calculator
  pom.artifactId=calculator
  pom.version=1.0
  pom.name =Calculator
  
  #parameters for artifact: context
  context.path=/calculator
  
  #parameters for artifact: sunjaxws
  sunjaxws.name=calculator
  sunjaxws.interfaceClass=com.alexanderperucci.calculator.Calculator
  sunjaxws.implementationClass=com.alexanderperucci.calculator.CalculatorImpl
  sunjaxws.urlPattern=/calculator
  sunjaxws.service=CalculatorService
  sunjaxws.port=CalculatorPort
  sunjaxws.targetNamespace=http://calculator.alexanderperucci.com/
  
  #parameters for artifact: web.xml
  webxml.dispalyName=calculator
  webxml.servletName=calculator
  webxml.urlPattern=/calculator
  
  #parameters for artifact: index.jsp
  index.title=calculator
  index.content=Hello by Calculator!
  
  #parameters customize wsimport command: Specifying a target package via this command-line option, overrides any wsdl and schema binding customization for package name and the default package name algorithm defined in the specification
  wsimport.package=com.alexanderperucci.calculator

</pre>

### calculator.wsdl

```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" name="CalculatorService"
                    targetNamespace="http://calculator.alexanderperucci.com/"
                    xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
                    xmlns:tns="http://calculator.alexanderperucci.com/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <wsdl:types>
          <xsd:schema attributeFormDefault="unqualified" elementFormDefault="unqualified"
                  targetNamespace="http://calculator.alexanderperucci.com/" xmlns:tns="http://calculator.alexanderperucci.com/"
                  xmlns:xsd="http://www.w3.org/2001/XMLSchema">
              <xsd:element name="multiply" type="tns:multiply"/>
              <xsd:complexType name="multiply">
                  <xsd:sequence>
                      <xsd:element name="arg0" type="xsd:int"/>
                      <xsd:element name="arg1" type="xsd:int"/>
                  </xsd:sequence>
              </xsd:complexType>
              <xsd:element name="multiplyResponse" type="tns:multiplyResponse"/>
              <xsd:complexType name="multiplyResponse">
                  <xsd:sequence>
                      <xsd:element name="return" type="xsd:int"/>
                  </xsd:sequence>
              </xsd:complexType>
              <xsd:element name="sum" type="tns:sum"/>
              <xsd:complexType name="sum">
                  <xsd:sequence>
                      <xsd:element name="arg0" type="xsd:int"/>
                      <xsd:element name="arg1" type="xsd:int"/>
                  </xsd:sequence>
              </xsd:complexType>
              <xsd:element name="sumResponse" type="tns:sumResponse"/>
              <xsd:complexType name="sumResponse">
                  <xsd:sequence>
                      <xsd:element name="return" type="xsd:int"/>
                  </xsd:sequence>
              </xsd:complexType>
          </xsd:schema>
      </wsdl:types>
      <wsdl:message name="multiplyResponse">
          <wsdl:part element="tns:multiplyResponse" name="parameters"/>
      </wsdl:message>
      <wsdl:message name="sumResponse">
          <wsdl:part element="tns:sumResponse" name="parameters"/>
      </wsdl:message>
      <wsdl:message name="sum">
          <wsdl:part element="tns:sum" name="parameters"/>
      </wsdl:message>
      <wsdl:message name="multiply">
          <wsdl:part element="tns:multiply" name="parameters"/>
      </wsdl:message>
      <wsdl:portType name="Calculator">
          <wsdl:operation name="multiply">
              <wsdl:input message="tns:multiply" name="multiply"/>
              <wsdl:output message="tns:multiplyResponse" name="multiplyResponse"/>
          </wsdl:operation>
          <wsdl:operation name="sum">
              <wsdl:input message="tns:sum" name="sum"/>
              <wsdl:output message="tns:sumResponse" name="sumResponse"/>
          </wsdl:operation>
      </wsdl:portType>
      <wsdl:binding name="CalculatorServiceSoapBinding" type="tns:Calculator">
          <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
          <wsdl:operation name="multiply">
              <soap:operation soapAction="" style="document"/>
              <wsdl:input name="multiply">
                  <soap:body use="literal"/>
              </wsdl:input>
              <wsdl:output name="multiplyResponse">
                  <soap:body use="literal"/>
              </wsdl:output>
          </wsdl:operation>
          <wsdl:operation name="sum">
              <soap:operation soapAction="" style="document"/>
              <wsdl:input name="sum">
                  <soap:body use="literal"/>
              </wsdl:input>
              <wsdl:output name="sumResponse">
                  <soap:body use="literal"/>
              </wsdl:output>
          </wsdl:operation>
      </wsdl:binding>
      <wsdl:service name="CalculatorService">
          <wsdl:port name="CalculatorPort" binding="tns:CalculatorServiceSoapBinding">
              <soap:address location="http://localhost:8080/calculator/calculator"/>
          </wsdl:port>
      </wsdl:service>
  </wsdl:definitions>
```

### generate a Web Service

<pre>
java -jar generateWebService.jar -p calculator.properties -wsdl calculator.wsdl
</pre>

## Reporting an Issue

1. Make sure the problem you're addressing is reproducible.

## Contribute
You can also support this project by donating on Gratipay [here](https://www.gratipay.com/alexander_perucci/)

## License
Licensed under the MPL version 2.0 license.

Copyright (c) 2014 Alexander Perucci.
