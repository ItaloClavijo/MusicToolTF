package pe.edu.upc.musictooltf.DTOs;

import pe.edu.upc.musictooltf.Entities.Purchase;

public class PurchaseContentDTO {
    private Integer idPurchaseContent;
    private Float purchaseContentPrice;
    private Integer idContent;
    private Purchase purchaseId;
    private int purchaseContentAvailableDownloads;

    public Integer getIdPurchaseContent() {
        return idPurchaseContent;
    }

    public void setIdPurchaseContent(Integer idPurchaseContent) {
        this.idPurchaseContent = idPurchaseContent;
    }

    public Float getPurchaseContentPrice() {
        return purchaseContentPrice;
    }

    public void setPurchaseContentPrice(Float purchaseContentPrice) {
        this.purchaseContentPrice = purchaseContentPrice;
    }

    public Integer getIdContent() {
        return idContent;
    }

    public void setIdContent(Integer idContent) {
        this.idContent = idContent;
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
