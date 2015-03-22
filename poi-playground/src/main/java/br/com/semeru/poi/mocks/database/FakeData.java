package br.com.semeru.poi.mocks.database;

import java.util.ArrayList;
import java.util.List;

import br.com.semeru.poi.Person;

public class FakeData {
	
	public List<Person> mockPersonsList(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) persons.add(mockPerson(i));
		return persons ;
	}
	
	private Person mockPerson(Integer i){
		Person person = new Person();
		
		person.idPerson = 1 + i;    
		person.name = "PESON NAME "+ i;         
		person.age = 1 + i;         
		person.gender = isEvenNumber(i) ? "FEMALE" : "MALE";       
		person.rgNumber = "113213"+ i;     
		person.cpfNumber = "323234"+ i;    
		person.birthDate = "01/06/" + 2000 + i;    
		person.address = "ADRESS X, ROAD ONE, NUMBER " + i;      
		person.phoneNumber1 = "12341"+i; 
		person.phoneNumber2 = "34255"+i; 
		person.religion = "RELIGION XYZ";     
		person.contact = "CALL TO PERSON NAME " + (i - 4);      
		person.father = "PERSON NAME " + (i - 46);       
		person.mother = "PERSON NAME " + (i - 12);       
		person.birthCity = "DUCK CITY ROCK";    
		person.workPlace = "SOMEWHERE ON EARTH";    
		person.salary = (1 + i.doubleValue());  
		return person;
	}
	
	private boolean isEvenNumber(Integer number){
		if((number%2)==0) return true;
		return false;
	}

}