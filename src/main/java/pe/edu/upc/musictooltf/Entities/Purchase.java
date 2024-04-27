package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPurchase;
    @Column(name="date", nullable = false)
    //es mejor porque se puede hacer reporte
    private LocalDate purchaseDate;
    @Column(name="paymentStatus", nullable = false)
    //Estado de compra
    private int purchasePaymentStatus;
    @Column(name="purchaseTotal", nullable = false)
    private Float purchaseTotal;
    @Column(name="planesId", nullable = false)
    private int planesId;
    /*
    @ManyToOne
    @JoinColumn(name = "userID")
    private  User userId;
     */

    public Purchase() {
    }

    public Purchase(Integer idPurchase, LocalDate purchaseDate, int purchasePaymentStatus, Float purchaseTotal, int planesId) {
        this.idPurchase = idPurchase;
        this.purchaseDate = purchaseDate;
        this.purchasePaymentStatus = purchasePaymentStatus;
        this.purchaseTotal = purchaseTotal;
        this.planesId = planesId;
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer id) {
        this.idPurchase = id;
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
}
