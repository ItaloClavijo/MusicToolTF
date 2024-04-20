package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Plan;

import java.util.List;

public interface IPlanService {
    public Plan insert(Plan plan);

    public List<Plan> list();

    public void delete (Integer id);

    public Plan findById(Integer id);

    public List<Plan> findByPlanName(String name);
}
