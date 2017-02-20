package ua.com.internet_shop.dto;

import ua.com.internet_shop.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DtoUtilMapper {
	

	public static List<GoodsDto> goodtoGoodsDto(List<Goods> goods){
		List<GoodsDto> goodsDtos = new ArrayList<GoodsDto>();
		
		for (Goods good: goods) {
			GoodsDto goodsDto = new GoodsDto();
			goodsDto.setName(good.getName());
			goodsDto.setId(good.getId());
			
			goodsDtos.add(goodsDto);
		}
		
		return goodsDtos;
	}
	
	public static List<CategoryDto> categoryToCategoryDto(List<Category> categories){
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		
		for (Category category : categories) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(category.getId());
			categoryDto.setName(category.getName());
			
			categoryDtos.add(categoryDto);
			
		}
		
		return categoryDtos;
	}
	
	public static List<UserDto> userToUserDto(List<User> users){
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for (User user : users) {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setPathImg(user.getPathImg());
			
			userDtos.add(userDto);
		}
		
		return userDtos;
	}

	public static List<DeliveryDto> deliveriesToDeliveriesDtos(List<Delivery> deliveries){
		List<DeliveryDto> deliveryDtos = new ArrayList<>();
		for (Delivery delivery: deliveries ) {
			deliveryDtos.add(new DeliveryDto(delivery.getId(), delivery.getName()));
		}
		return deliveryDtos;
	}

	public static List<CartDto> cartToCartDtos(List<Cart> carts){
		List<CartDto> cartDtos = new ArrayList<>();
		for (Cart cart: carts){
			cartDtos.add(new CartDto(cart.getQuantity()));
		}
		return cartDtos;
	}

}
