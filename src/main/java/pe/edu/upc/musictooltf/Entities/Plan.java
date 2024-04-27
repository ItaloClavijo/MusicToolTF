package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String planName;

    @Column(name = "price", nullable = false)
    private Double planPrice;

    @Column(name = "description", nullable = false, length = 250)
    private String planDescription;

    @Column(name = "startDate", nullable = false)
    private LocalDate planStartDate;

    @Column(name = "finalDate", nullable = false)
    private LocalDate planFinalDate;

    public Plan(Integer id, String planName, Double planPrice, String planDescription, LocalDate planStartDate, LocalDate planFinalDate) {
        this.id = id;
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDescription = planDescription;
        this.planStartDate = planStartDate;
        this.planFinalDate = planFinalDate;
    }

    public Plan() {
    }

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