package ua.com.internet_shop.dto;

public class CartDto {

    private short quantity;

    public CartDto() {
    }

    public CartDto(short quantity) {
        this.quantity = quantity;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

}
