package br.com.semeru.poi;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    public Integer idPerson;
    public String name;
    public Integer age;
    public String gender;
    public String rgNumber;
    public String cpfNumber;
    public String birthDate;
    public String address;
    public String phoneNumber1;
    public String phoneNumber2;
    public String religion;
    public String contact;
    public String father;
    public String mother;
    public String birthCity;
    public String workPlace;
    public Double salary;
	
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPerson == null) ? 0 : idPerson.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (idPerson == null) {
			if (other.idPerson != null)
				return false;
		} else if (!idPerson.equals(other.idPerson))
			return false;
		return true;
	}
}