package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.SubscriptionDTO;
import pe.edu.upc.musictooltf.Entities.Subscription;
import pe.edu.upc.musictooltf.Services.ISubscriptionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/subscriptions")
public class SubscriptionController {
    @Autowired
    private ISubscriptionService subscriptionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Subscription save(@RequestBody @Validated SubscriptionDTO subscriptionDTO){
        ModelMapper m = new ModelMapper();
        Subscription subscription = m.map(subscriptionDTO,Subscription.class);
        return subscriptionService.insert(subscription);
    }

    @GetMapping
    public List<SubscriptionDTO> list(){
        return subscriptionService.list().stream().map(y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y,SubscriptionDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        subscriptionService.delete(id);
    }

    @GetMapping("/{id}")
    public SubscriptionDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        SubscriptionDTO subscriptionDTO = m.map(subscriptionService.findById(id),SubscriptionDTO.class);
        return subscriptionDTO;
    }
}
