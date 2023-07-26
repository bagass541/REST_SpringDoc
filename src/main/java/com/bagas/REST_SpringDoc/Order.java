package com.bagas.REST_SpringDoc;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="CUSTOMER_ORDER")
@NoArgsConstructor
@Data
public class Order {

	private @Id @GeneratedValue Long id;
	
	private String description;
	private Status status;
	
	Order(String description, Status Status)
	{
		this.description = description;
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o)
	{
		
		if(this == o)
			return true;
		if(!(o instanceof Order))
			return false;
		
		Order order = (Order) o;
		return Objects.equals(this.id, order.id) && Objects.equals(this.description, order.description)
				&& this.status == order.status;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.id, this.description, this.status);
	}
	
	@Override
	public String toString()
	{
		return "Order{" + "id=" + this.id + ", description='" + this.description + '\'' + ", status=" + this.status + '}';
	}
}
