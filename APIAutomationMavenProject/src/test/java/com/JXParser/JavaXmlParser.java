package com.JXParser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JavaXmlParser {
public void marshalling(Employee eobj) throws JAXBException {
	JAXBContext jc = JAXBContext.newInstance(Employee.class);
	Marshaller m = jc.createMarshaller();
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	m.marshal(eobj, System.out);
	m.marshal(eobj, new File("Employee.xml"));
}}

class XmlJavaParser{
	public void unmarshalling(String filename) throws JAXBException {
	JAXBContext jc = JAXBContext.newInstance(Employee.class);
	Unmarshaller um = jc.createUnmarshaller();
	Employee eobj = (Employee)um.unmarshal(new File(filename));
	System.out.println(eobj);
	}
}
