package pe.edu.upc.musictooltf.DTOs;
import pe.edu.upc.musictooltf.Entities.PurchaseContent;
import pe.edu.upc.musictooltf.Entities.Users;

import java.time.LocalDate;
import java.util.List;

public class PurchaseDTO {
    private Integer id;
    private LocalDate purchaseDate;
    private int purchasePaymentStatus;
    private Float purchaseTotal;
    private Users customer;
    private List<PurchaseContent> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getPurchasePaymentStatus() {
        return purchasePaymentStatus;
    }

    public void setPurchasePaymentStatus(int purchasePaymentStatus) {
        this.purchasePaymentStatus = purchasePaymentStatus;
    }

    public Float getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Float purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public Users getCustomer() {
        return customer;
    }

    public void setCustomer(Users customer) {
        this.customer = customer;
    }

    public List<PurchaseContent> getItems() {
        return items;
    }

    public void setItems(List<PurchaseContent> items) {
        this.items = items;
    }
}
