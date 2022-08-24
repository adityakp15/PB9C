package com.barclays.demospring.model;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringToObject {

	public static void main(String[] args) {
		SpringApplication.run(StringToObject.class, args);

		JavaObjectArraytoJSON();
		JSONToJavaObjectArray();
	}

	public static void JavaObjectArraytoJSON() {
		Student student1 = new Student();
		student1.setId(100);
		student1.setName("Yawin");
		
		Student student2 = new Student();
		student2.setId(101);
		student2.setName("Spring Boot");

		Student[] studentArray = new Student[2];
		studentArray[0] = student1;
		studentArray[1] = student2;
		
		Jsonb jsonb = JsonbBuilder.create();
		String jsonString = jsonb.toJson(studentArray);
		System.out.println("Json format String : " + jsonString);
	}

	public static void JSONToJavaObjectArray() {
		String jsonString = "[{\"id\":100,\"name\":\"Yawin\"},{\"id\":101,\"name\":\"Spring Boot\"}]";

		Jsonb jsonb = JsonbBuilder.create();
		Student[] studentArray = jsonb.fromJson(jsonString, new Student[] {}.getClass() );
		for(Student st : studentArray) {
			System.out.println(st.getId() + " " + st.getName());
		}
		
	}	
}


