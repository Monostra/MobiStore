package ua.com.internet_shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
	private List<Orders> orders;
	
	public Delivery() {
	}

	public Delivery(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", name=" + name + "]";
	}

	
}
