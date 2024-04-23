package pe.edu.upc.musictooltf.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubscription;

    @Column(name = "state", nullable = false, length = 50)
    private String stateSubscription;

    @Column(name = "total", nullable = false)
    private Double totalSubscription;

    @Column(name = "date", nullable = false)
    private LocalDate dateSubscription;

    public Subscription(Integer idSubscription, String stateSubscription, Double totalSubscription, LocalDate dateSubscription) {
        this.idSubscription = idSubscription;
        this.stateSubscription = stateSubscription;
        this.totalSubscription = totalSubscription;
        this.dateSubscription = dateSubscription;
    }

    public Subscription() {
    }

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
}
