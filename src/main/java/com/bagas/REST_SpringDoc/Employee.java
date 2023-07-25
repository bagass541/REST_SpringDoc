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
	private String name;
	private String role;
	
	public Employee(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	@Override
	public boolean equals(Object o)
	{
		
		if(this == o)
			return true;
		
		if(!(o instanceof Employee))
			return false;
		
		Employee employee = (Employee) o;
		return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
				&& Objects.equals(this.role, employee.role);
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.id, this.name, this.role);
	}
	
	@Override
	public String toString()
	{
		return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='"
				+ this.role + '\'' + '}';
	}
	
}
