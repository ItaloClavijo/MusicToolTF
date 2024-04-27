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

    //Estado de compra
    @Column(name="paymentStatus", nullable = false)
    private String purchasePaymentStatus;

    @Column(name = "total", nullable = false)
    private Double totalSubscription;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStartSubscription;

    @Column(name = "date_end", nullable = false)
    private LocalDate dateEndSubscription;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan planId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users usersId;

    public Subscription(Integer idSubscription, String stateSubscription, String purchasePaymentStatus, Double totalSubscription, LocalDate dateStartSubscription, LocalDate dateEndSubscription, Plan planId, Users usersId) {
        this.idSubscription = idSubscription;
        this.stateSubscription = stateSubscription;
        this.purchasePaymentStatus = purchasePaymentStatus;
        this.totalSubscription = totalSubscription;
        this.dateStartSubscription = dateStartSubscription;
        this.dateEndSubscription = dateEndSubscription;
        this.planId = planId;
        this.usersId = usersId;
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

    public LocalDate getDateStartSubscription() {
        return dateStartSubscription;
    }

    public void setDateStartSubscription(LocalDate dateStartSubscription) {
        this.dateStartSubscription = dateStartSubscription;
    }

    public LocalDate getDateEndSubscription() {
        return dateEndSubscription;
    }

    public void setDateEndSubscription(LocalDate dateEndSubscription) {
        this.dateEndSubscription = dateEndSubscription;
    }

    public String getPurchasePaymentStatus() {
        return purchasePaymentStatus;
    }

    public void setPurchasePaymentStatus(String purchasePaymentStatus) {
        this.purchasePaymentStatus = purchasePaymentStatus;
    }

    public Plan getPlanId() {
        return planId;
    }

    public void setPlanId(Plan planId) {
        this.planId = planId;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }
}
