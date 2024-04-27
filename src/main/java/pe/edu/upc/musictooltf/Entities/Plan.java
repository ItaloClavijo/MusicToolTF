package pe.edu.upc.musictooltf.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_id")
    private List<Subscription> subs;


    public Plan(Integer id, String planName, Double planPrice, String planDescription, List<Subscription> subs) {
        this.id = id;
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDescription = planDescription;
        this.subs = subs;
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

    public List<Subscription> getSubs() {
        return subs;
    }

    public void setSubs(List<Subscription> subs) {
        this.subs = subs;
    }
}