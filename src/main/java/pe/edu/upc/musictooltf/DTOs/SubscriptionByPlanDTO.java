package pe.edu.upc.musictooltf.DTOs;

public class SubscriptionByPlanDTO {
    private String namePlan;

    private Integer quantitySubscription;

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public Integer getQuantitySubscription() {
        return quantitySubscription;
    }

    public void setQuantitySubscription(Integer quantitySubscription) {
        this.quantitySubscription = quantitySubscription;
    }
}
