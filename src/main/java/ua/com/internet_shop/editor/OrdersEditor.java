package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.OrdersService;

import java.beans.PropertyEditorSupport;

public class OrdersEditor extends PropertyEditorSupport{

    private final OrdersService ordersService;

    public OrdersEditor(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(ordersService.findOne(Integer.parseInt(text)));
    }
}
