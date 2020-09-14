package com.JXParser;

import javax.xml.bind.JAXBException;

public class TestXmlJava {
	public static void main(String[] args) throws JAXBException {
		XmlJavaParser p=new XmlJavaParser();
		p.unmarshalling("Employee.xml");
	}
}
