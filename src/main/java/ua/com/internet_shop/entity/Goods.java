package ua.com.internet_shop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Goods {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String article;
	private String metaTitle;
	private String metaDescription;
	private String shortDescription;
	private String longDescrtipion;
	private String specification;
	private boolean visible;
	private float price;
	private float discount;
	private LocalDate discountDate;
	private LocalDateTime dateTime;
	private String img;

	@ManyToOne(fetch = FetchType.LAZY)
	private EyesStoppers eyesStoppers;
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

//	@ManyToMany
//	@JoinTable(name="goodsZakaz", joinColumns = @JoinColumn(name = "goodsId"), inverseJoinColumns = @JoinColumn(name = "zakazId"))
//	private List<Zakaz> zakazs;
//	@ManyToMany
//	@JoinTable(name = "goodsCart", joinColumns = @JoinColumn(name = "goodsId"), inverseJoinColumns = @JoinColumn(name = "cartId"))
//	private List<Cart> carts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goods")
	private List<Zakaz> zakazs;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goods")
	private List<Cart> carts;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goods", cascade = CascadeType.ALL)
	private List<Images> images;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goods")
	private List<Reviews> reviews;

	public Goods() {
	}

	public Goods(String name, String article, String metaTitle, String metaDescription, String shortDescription, String longDescrtipion, String specification, boolean visible, float price, float discount, LocalDate discountDate, LocalDateTime dateTime, String img) {
		this.name = name;
		this.article = article;
		this.metaTitle = metaTitle;
		this.metaDescription = metaDescription;
		this.shortDescription = shortDescription;
		this.longDescrtipion = longDescrtipion;
		this.specification = specification;
		this.visible = visible;
		this.price = price;
		this.discount = discount;
		this.discountDate = discountDate;
		this.dateTime = dateTime;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescrtipion() {
		return longDescrtipion;
	}

	public void setLongDescrtipion(String longDescrtipion) {
		this.longDescrtipion = longDescrtipion;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public LocalDate getDiscountDate() {
		return discountDate;
	}

	public void setDiscountDate(LocalDate discountDate) {
		this.discountDate = discountDate;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public EyesStoppers getEyesStoppers() {
		return eyesStoppers;
	}

	public void setEyesStoppers(EyesStoppers eyesStoppers) {
		this.eyesStoppers = eyesStoppers;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Zakaz> getZakazs() {
		return zakazs;
	}

	public void setZakazs(List<Zakaz> zakazs) {
		this.zakazs = zakazs;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", name='" + name + '\'' +
				", article='" + article + '\'' +
				", metaTitle='" + metaTitle + '\'' +
				", metaDescription='" + metaDescription + '\'' +
				", shortDescription='" + shortDescription + '\'' +
				", longDescrtipion='" + longDescrtipion + '\'' +
				", specification='" + specification + '\'' +
				", visible=" + visible +
				", price=" + price +
				", discount=" + discount +
				", discountDate=" + discountDate +
				", dateTime=" + dateTime +
				", img='" + img + '\'' +
				'}';
	}
}
