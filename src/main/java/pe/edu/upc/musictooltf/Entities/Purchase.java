package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPurchase;
    @Column(name="date", nullable = false)
    //es mejor porque se puede hacer reporte
    private LocalDateTime purchaseDate;
    @Column(name="paymentStatus", nullable = false)
    //Estado de compra
    private String purchasePaymentStatus;

    @Column(name="purchaseTotal", nullable = false)
    private Float purchaseTotal;

    @OneToMany(mappedBy = "purchaseId", cascade = CascadeType.ALL)
    private List<PurchaseContent> items;

    /*
    @ManyToOne
    @JoinColumn(name = "userID")
    private  User userId;
     */

    public Purchase() {
    }

    public Purchase(Integer idPurchase, LocalDateTime purchaseDate, String purchasePaymentStatus, Float purchaseTotal, List<PurchaseContent> items) {
        this.idPurchase = idPurchase;
        this.purchaseDate = purchaseDate;
        this.purchasePaymentStatus = purchasePaymentStatus;
        this.purchaseTotal = purchaseTotal;
        this.items = items;
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer id) {
        this.idPurchase = id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchasePaymentStatus() {
        return purchasePaymentStatus;
    }

    public void setPurchasePaymentStatus(String purchasePaymentStatus) {
        this.purchasePaymentStatus = purchasePaymentStatus;
    }

    public Float getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Float purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public List<PurchaseContent> getItems() {
        return items;
    }

    public void setItems(List<PurchaseContent> items) {
        this.items = items;
    }
}
