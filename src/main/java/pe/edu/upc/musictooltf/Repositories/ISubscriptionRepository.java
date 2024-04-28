package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Subscription;

import java.util.List;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription,Integer> {
    @Query(value = "SELECT p.name AS nombre_plan, SUM(s.total) AS ingreso_total \n" +
            "FROM plan p INNER JOIN subscription s \n" +
            "ON p.id = s.plan_id \n" +
            "GROUP BY p.name", nativeQuery = true)
    public List<String[]> totalIncomeByPlan();
}
