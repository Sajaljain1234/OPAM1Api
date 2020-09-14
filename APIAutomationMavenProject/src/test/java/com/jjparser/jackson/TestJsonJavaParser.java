package com.jjparser.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class TestJsonJavaParser {
public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	JsonJavaParser p=new JsonJavaParser();
	Person pobj = p.unmarshalling("Person.json", Person.class);
	System.out.println(pobj);
}
}
