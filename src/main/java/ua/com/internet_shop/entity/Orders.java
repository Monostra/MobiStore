package ua.com.internet_shop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String text;
	private LocalDateTime date;

	@ManyToOne(fetch = FetchType.LAZY)
	private Delivery delivery;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="orders")
	private List<Zakaz> zakazs;

//	@ManyToMany
//	@JoinTable(name = "ordersUser", joinColumns = @JoinColumn(name = "ordersId"), inverseJoinColumns = @JoinColumn(name = "userId"))
//	private List<User> users;

	public Orders() {
	}
	
	
	public Orders(int id, String text, LocalDateTime date, Delivery delivery, List<Zakaz> zakazs) {
		super();
		this.id = id;
		this.text = text;
		this.date = date;
		this.delivery = delivery;
		this.zakazs = zakazs;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public List<Zakaz> getZakazs() {
		return zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", text=" + text + ", date=" + date + "]";
	}


	

	
	
	
	
	
	
}
