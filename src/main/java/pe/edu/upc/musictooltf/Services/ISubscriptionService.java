package pe.edu.upc.musictooltf.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import pe.edu.upc.musictooltf.Entities.Subscription;

import java.util.List;

public interface ISubscriptionService {
    public Subscription insert(Integer plan_id, Long user_id);

    public List<Subscription> list();

    public void delete(Integer id);

    public Subscription findById(Integer id);

    public List<String[]> totalIncomeByPlan();

}
