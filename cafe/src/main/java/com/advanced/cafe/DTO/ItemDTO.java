package com.advanced.cafe.DTO;

public class ItemDTO {
    private BeverageDTO beverageDTO;
    private String size;
    private int quantity;

    public ItemDTO() {
    }

    public ItemDTO(BeverageDTO beverageDTO, String size, int quantity) {
        this.beverageDTO = beverageDTO;
        this.size = size;
        this.quantity = quantity;
    }

    public BeverageDTO getBeverageDTO() {
        return beverageDTO;
    }

    public void setBeverageDTO(BeverageDTO beverageDTO) {
        this.beverageDTO = beverageDTO;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
