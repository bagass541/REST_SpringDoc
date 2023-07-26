package com.bagas.REST_SpringDoc;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Employee {
	
	private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String role;
	
	public Employee(String firstName, String lastName, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	public String getName()
	{
		return this.firstName + " " + this.lastName;
	} 
	
	public void setName(String name)
	{
		String[] parts = name.split(" ");
		this.firstName = parts[0];
		this.lastName = parts[1];
	}
	
	@Override
	public boolean equals(Object o)
	{
		
		if(this == o)
			return true;
		
		if(!(o instanceof Employee))
			return false;
		
		Employee employee = (Employee) o;
		return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.firstName)
				&& Objects.equals(this.lastName, employee.lastName)  && Objects.equals(this.role, employee.role);
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.id, this.firstName, this.lastName, this.role);
	}
	
	@Override
	public String toString()
	{
		return "Employee{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
				+ ", role='" + this.role + '\'' + '}';
	}
	
}
