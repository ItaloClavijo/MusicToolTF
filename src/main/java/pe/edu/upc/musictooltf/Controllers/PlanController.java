package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.PlanDTO;
import pe.edu.upc.musictooltf.Entities.Plan;
import pe.edu.upc.musictooltf.Services.IPlanService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musictool/plans")
public class PlanController {
    @Autowired
    private IPlanService planService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Plan save(@RequestBody @Validated PlanDTO planDTO){
        ModelMapper m = new ModelMapper();
        Plan plan = m.map(planDTO,Plan.class);
        return planService.insert(plan);
    }

    @GetMapping
    public List<PlanDTO> list(){
        return planService.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PlanDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){ planService.findById(id); }

    @GetMapping("/{id}")
    public PlanDTO listId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        PlanDTO planDTO = m.map(planService.findById(id),PlanDTO.class);
        return planDTO;
    }

    @GetMapping("/find")
    public List<PlanDTO> findName(@RequestParam String name){
        return planService.findByPlanName(name).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PlanDTO.class);
        }).collect(Collectors.toList());
    }
}