package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Plan;

import java.util.List;

@Repository
public interface IPlanRepository extends JpaRepository<Plan,Integer> {
    public List<Plan> findByPlanName(String name);
}
