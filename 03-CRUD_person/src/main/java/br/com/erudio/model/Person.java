package br.com.erudio.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//atributos da classe
	private Long id;
	private String fristName;
	private String lastName;
	private String address; // endereço
	private String gender; //sexo

	//construtor padrãp
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	

	public Person(Long id, String fristName, String lastName, String address, String gender) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}


	//gets e sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//hashcode e equals
	@Override
	public int hashCode() {
		return Objects.hash(address, fristName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(fristName, other.fristName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
	

}
