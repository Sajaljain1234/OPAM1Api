package com.jjparser.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class TestJavaJsonParser {
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	Person pobj=new Person("sajal","TE",10,80000);
	JavaJsonParser p = new JavaJsonParser();
	p.marshalling(pobj);
	System.out.println("pass");//just for our confirmation
}
}
