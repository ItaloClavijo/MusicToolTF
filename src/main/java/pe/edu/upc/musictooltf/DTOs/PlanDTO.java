package pe.edu.upc.musictooltf.DTOs;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class PlanDTO {
    private Integer id;

    private String planName;

    private Double planPrice;

    private String planDescription;

    private LocalDate planStartDate;

    private LocalDate planFinalDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Double getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(Double planPrice) {
        this.planPrice = planPrice;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public LocalDate getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(LocalDate planStartDate) {
        this.planStartDate = planStartDate;
    }

    public LocalDate getPlanFinalDate() {
        return planFinalDate;
    }

    public void setPlanFinalDate(LocalDate planFinalDate) {
        this.planFinalDate = planFinalDate;
    }
}
