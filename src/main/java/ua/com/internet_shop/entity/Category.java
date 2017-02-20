package ua.com.internet_shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String metaTitle;
	private String metaDescription;
	private short position;
	private int parents;
	private String pathImg;
	private boolean visible;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Goods> goods;
	
	public Category() {
	}

	public Category(String name, String metaTitle, String metaDescription, short position, int parents, String pathImg, boolean visible) {
		this.name = name;
		this.metaTitle = metaTitle;
		this.metaDescription = metaDescription;
		this.position = position;
		this.parents = parents;
		this.pathImg = pathImg;
		this.visible = visible;
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

	public short getPosition() {
		return position;
	}

	public void setPosition(short position) {
		this.position = position;
	}

	public int getParents() {
		return parents;
	}

	public void setParents(int parents) {
		this.parents = parents;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", metaTitle='" + metaTitle + '\'' +
				", metaDescription='" + metaDescription + '\'' +
				", position=" + position +
				", parents=" + parents +
				", pathImg='" + pathImg + '\'' +
				", visible=" + visible +
				'}';
	}


	
	
}
