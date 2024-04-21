package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PurchaseContent")
public class PurchaseContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //compra contenido
    private Integer idPurchaseContent;
    //precio compra de contenido
    @Column(name ="price")
    private Float purchaseContentPrice;
    @Column(name ="idContent")
    private Integer idContent;
    @ManyToOne
    @JoinColumn(name = "purchaseId")
    private Purchase purchaseId;
    //descargas disponibles
    @Column(name ="availableDownloads")
    private int purchaseContentAvailableDownloads;

    public PurchaseContent() {
    }

    public PurchaseContent(Integer idPurchaseContent, Float purchaseContentPrice, Integer idContent, Purchase purchaseId, int purchaseContentAvailableDownloads) {
        this.idPurchaseContent = idPurchaseContent;
        this.purchaseContentPrice = purchaseContentPrice;
        this.idContent = idContent;
        this.purchaseId = purchaseId;
        this.purchaseContentAvailableDownloads = purchaseContentAvailableDownloads;
    }

    public Integer getIdContent() {
        return idContent;
    }

    public void setIdContent(Integer idContent) {
        this.idContent = idContent;
    }

    public Integer getIdPurchaseContent() {
        return idPurchaseContent;
    }

    public void setIdPurchaseContent(Integer id) {
        this.idPurchaseContent = id;
    }

    public Float getPurchaseContentPrice() {
        return purchaseContentPrice;
    }

    public void setPurchaseContentPrice(Float purchaseContentPrice) {
        this.purchaseContentPrice = purchaseContentPrice;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getPurchaseContentAvailableDownloads() {
        return purchaseContentAvailableDownloads;
    }

    public void setPurchaseContentAvailableDownloads(int purchaseContentAvailableDownloads) {
        this.purchaseContentAvailableDownloads = purchaseContentAvailableDownloads;
    }
}
