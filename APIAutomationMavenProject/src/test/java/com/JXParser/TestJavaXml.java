package com.JXParser;

import javax.xml.bind.JAXBException;

public class TestJavaXml {
public static void main(String[] args) throws JAXBException {
	Employee eobj = new Employee("Sajal","TE",25,30000);
	JavaXmlParser p=new JavaXmlParser();
	p.marshalling(eobj);
}
}

