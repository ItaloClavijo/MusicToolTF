package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.PurchaseDTO;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Services.IPurchaseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/purchase")
public class PurchaseController {
    @Autowired
    private IPurchaseService purchaseService;
    @PostMapping
    public void insert(@RequestBody List<Integer> contentIds) {
        purchaseService.create(contentIds);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        purchaseService.delete(id);
    }

    @GetMapping
    public List<PurchaseDTO> buysList() {
        return purchaseService.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PurchaseDTO.class);}
        ).collect(Collectors.toList());
    }
}
