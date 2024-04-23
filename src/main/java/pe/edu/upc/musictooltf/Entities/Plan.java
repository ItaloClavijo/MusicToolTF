package pe.edu.upc.musictooltf.Entities;

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

    @Column(name = "startDate", nullable = false)
    private LocalDate planStartDate;

    @Column(name = "finalDate", nullable = false)
    private LocalDate planFinalDate;

    @OneToOne
    @JoinColumn(name = "user_idp")
    private Users usersId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_id")
    private List<Subscription> subscription;

    public Plan(Integer id, String planName, Double planPrice, String planDescription, LocalDate planStartDate, LocalDate planFinalDate, Users usersId, List<Subscription> subscription) {
        this.id = id;
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDescription = planDescription;
        this.planStartDate = planStartDate;
        this.planFinalDate = planFinalDate;
        this.usersId = usersId;
        this.subscription = subscription;
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

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    public List<Subscription> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<Subscription> subscription) {
        this.subscription = subscription;
    }
}