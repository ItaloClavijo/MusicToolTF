package pe.edu.upc.musictooltf.DTOs;

import jakarta.persistence.Column;
import pe.edu.upc.musictooltf.Entities.Plan;

import java.time.LocalDate;

public class SubscriptionDTO {
    private Integer idSubscription;

    private String stateSubscription;

    private Double totalSubscription;

    private LocalDate dateSubscription;

    private Plan planId;

    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }

    public String getStateSubscription() {
        return stateSubscription;
    }

    public void setStateSubscription(String stateSubscription) {
        this.stateSubscription = stateSubscription;
    }

    public Double getTotalSubscription() {
        return totalSubscription;
    }

    public void setTotalSubscription(Double totalSubscription) {
        this.totalSubscription = totalSubscription;
    }

    public LocalDate getDateSubscription() {
        return dateSubscription;
    }

    public void setDateSubscription(LocalDate dateSubscription) {
        this.dateSubscription = dateSubscription;
    }

    public Plan getPlanId() {
        return planId;
    }

    public void setPlanId(Plan planId) {
        this.planId = planId;
    }
}
