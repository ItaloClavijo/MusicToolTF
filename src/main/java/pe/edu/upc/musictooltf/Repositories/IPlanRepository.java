package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Plan;

import java.util.List;

@Repository
public interface IPlanRepository extends JpaRepository<Plan,Integer> {
    public List<Plan> findByPlanName(String name);

    @Query(value = "SELECT p.name AS planName, COUNT(*) AS SubQuantity \n" +
            "FROM subscription s INNER JOIN plan p \n" +
            "ON s.plan_id = p.id GROUP BY p.name", nativeQuery = true)
    public List<String[]> subscriptionQuantityByPlan();
}
