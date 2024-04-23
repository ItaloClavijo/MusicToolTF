package pe.edu.upc.musictooltf.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import pe.edu.upc.musictooltf.Entities.Subscription;

import java.util.List;

public interface ISubscriptionService {
    public Subscription insert(Subscription subscription);

    public List<Subscription> list();

    public void delete(Integer id);

    public Subscription findById(Integer id);
}
