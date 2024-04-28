package pe.edu.upc.musictooltf.DTOs;

import pe.edu.upc.musictooltf.Entities.Users;

import java.time.LocalDate;

public class PurchaseDTO {
    private Integer id;
    private LocalDate purchaseDate;
    private int purchasePaymentStatus;
    private Float purchaseTotal;
    private int planesId;

    private Users user;

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

    public int getPlanesId() {
        return planesId;
    }

    public void setPlanesId(int planesId) {
        this.planesId = planesId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
