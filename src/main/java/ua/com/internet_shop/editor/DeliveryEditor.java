package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.DeliveryService;

import java.beans.PropertyEditorSupport;

public class DeliveryEditor extends PropertyEditorSupport{

    private final DeliveryService deliveryService;

    public DeliveryEditor(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(deliveryService.findOne(Integer.parseInt(text)));
    }
}
