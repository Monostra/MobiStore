package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.UserService;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport{
	
	private final UserService userService;
	
	public UserEditor(UserService userService){
		this.userService = userService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(userService.findOne(Integer.parseInt(text)));
	}
	
	
}
