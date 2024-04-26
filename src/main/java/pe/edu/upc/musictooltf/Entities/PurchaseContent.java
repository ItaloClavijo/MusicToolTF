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

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content contentId;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchaseId;

    //descargas disponibles
    @Column(name ="availableDownloads")
    private int purchaseContentAvailableDownloads;

    public PurchaseContent() {
    }

    public PurchaseContent(Integer idPurchaseContent, Float purchaseContentPrice, Content idContent, Purchase purchaseId, int purchaseContentAvailableDownloads) {
        this.idPurchaseContent = idPurchaseContent;
        this.purchaseContentPrice = purchaseContentPrice;
        this.contentId = idContent;
        this.purchaseId = purchaseId;
        this.purchaseContentAvailableDownloads = purchaseContentAvailableDownloads;
    }

    public Content getIdContent() {
        return contentId;
    }

    public void setIdContent(Content idContent) {
        this.contentId = idContent;
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
