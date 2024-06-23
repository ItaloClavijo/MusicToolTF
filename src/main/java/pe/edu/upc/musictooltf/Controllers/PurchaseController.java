package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.PurchaseDTO;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Services.IPurchaseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/purchase")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseController {
    @Autowired
    private IPurchaseService purchaseService;


    @PostMapping
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")

    public Purchase insert(@RequestBody List<Integer> contentIds) {
        return purchaseService.create(contentIds);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id) {
        purchaseService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public List<PurchaseDTO> buysList() {
        return purchaseService.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PurchaseDTO.class);}
        ).collect(Collectors.toList());
    }
}
