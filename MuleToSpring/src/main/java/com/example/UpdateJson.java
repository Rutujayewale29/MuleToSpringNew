package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;



public class UpdateJson {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		String data = "";
		String filePath="C:\\Users\\Tanmay Yewale\\git\\MuleToSpringNew\\MuleToSpring\\src\\main\\java\\com\\example\\Result.json";
		FileReader reader = new FileReader(filePath);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        @SuppressWarnings("unused")
		String name =String.valueOf((String) data.getBytes().toString());
		jsonObject.put("name","Helloworld");
		System.out.println(jsonObject);
		FileWriter writer = new FileWriter(filePath, false); //overwrites the content of file
		writer.write(jsonObject.toString());
		writer.close();
		}
	}
