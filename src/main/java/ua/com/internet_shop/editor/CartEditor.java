package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.CartService;

import java.beans.PropertyEditorSupport;

public class CartEditor extends PropertyEditorSupport {

    private final CartService cartService;

    public CartEditor(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(cartService.findOne(Integer.parseInt(text)));
    }
}
