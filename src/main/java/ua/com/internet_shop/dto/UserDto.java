package ua.com.internet_shop.dto;

public class UserDto {
	
	private int id;
	private String pathImg;
	
	public UserDto() {
	}

	public UserDto(String pathImg) {
		this.pathImg = pathImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	
	
}
