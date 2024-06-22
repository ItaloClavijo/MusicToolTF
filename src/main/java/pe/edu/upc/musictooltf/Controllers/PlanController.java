package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.PlanDTO;
import pe.edu.upc.musictooltf.DTOs.SubscriptionByPlanDTO;
import pe.edu.upc.musictooltf.Entities.Plan;
import pe.edu.upc.musictooltf.Services.IPlanService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musictool/plans")
public class PlanController {
    @Autowired
    private IPlanService planService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public Plan save(@RequestBody @Validated PlanDTO planDTO){
        ModelMapper m = new ModelMapper();
        Plan plan = m.map(planDTO,Plan.class);
        return planService.insert(plan);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public List<PlanDTO> list(){
        return planService.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PlanDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id){ planService.delete(id); }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public PlanDTO listId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        PlanDTO planDTO = m.map(planService.findById(id),PlanDTO.class);
        return planDTO;
    }

    @GetMapping("/find")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public List<PlanDTO> findName(@RequestParam String name){
        return planService.findByPlanName(name).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PlanDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/quantitySubscriptionByPlan")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MELOMANO')")
    public List<SubscriptionByPlanDTO> quantitySubscriptionByPlan(){
        List<String[]> rowList = planService.subscriptionQuantityByPlan();
        List<SubscriptionByPlanDTO> dtoList= new ArrayList<>();

        for(String[] column : rowList) {
            SubscriptionByPlanDTO dto = new SubscriptionByPlanDTO();
            dto.setNamePlan(column[0]);
            dto.setQuantitySubscription(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }
}