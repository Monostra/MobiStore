package ua.com.internet_shop.entity;

import javax.persistence.*;

@Entity
public class Zakaz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private float price;

//	@ManyToMany
//	@JoinTable(name="goodsZakaz", joinColumns = @JoinColumn(name = "zakazId"), inverseJoinColumns = @JoinColumn(name = "goodsId"))
//	private List<Goods> goods;

	@ManyToOne(fetch = FetchType.LAZY)
	private Orders orders;
	@ManyToOne(fetch = FetchType.LAZY)
	private Goods goods;
	
	public Zakaz() {
	}

	public Zakaz(int quantity, float price) {
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//	public List<Goods> getGoods() {
//		return goods;
//	}
//
//	public void setGoods(List<Goods> goods) {
//		this.goods = goods;
//	}


	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Zakaz{" +
				"id=" + id +
				", quantity=" + quantity +
				", price=" + price +
				'}';
	}
}
