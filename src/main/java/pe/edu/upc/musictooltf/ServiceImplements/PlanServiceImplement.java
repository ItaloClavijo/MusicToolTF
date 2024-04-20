package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Plan;
import pe.edu.upc.musictooltf.Repositories.IPlanRepository;
import pe.edu.upc.musictooltf.Services.IPlanService;

import java.util.List;

@Service
public class PlanServiceImplement implements IPlanService {

    @Autowired
    private IPlanRepository planRepository;

    @Override
    public Plan insert(Plan plan) { return planRepository.save(plan); }

    @Override
    public List<Plan> list() { return planRepository.findAll(); }

    @Override
    public void delete(Integer id) { planRepository.deleteById(id); }

    @Override
    public Plan findById(Integer id) { return planRepository.findById(id).orElseThrow(); }

    @Override
    public List<Plan> findByPlanName(String name) { return planRepository.findByPlanName(name); }
}
