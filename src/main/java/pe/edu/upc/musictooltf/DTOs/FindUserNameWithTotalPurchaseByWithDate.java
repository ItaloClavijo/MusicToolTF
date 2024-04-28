package pe.edu.upc.musictooltf.DTOs;

import java.time.LocalDate;

public class FindUserNameWithTotalPurchaseByWithDate {
    private String userName;

    private LocalDate date;

    private Double totalPurchase;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
}
