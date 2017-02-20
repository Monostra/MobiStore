package ua.com.internet_shop.dto;

public class GoodsDto {
	
	private int id;
	private String name;

	public GoodsDto() {
	}

	
	public GoodsDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	

}
