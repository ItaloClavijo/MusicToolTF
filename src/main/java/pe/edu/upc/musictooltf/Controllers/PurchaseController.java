package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.PurchaseDTO;
import pe.edu.upc.musictooltf.DTOs.UserNameByTotalcompraByDateDTO;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Services.IPurchaseService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/purchase")
public class PurchaseController {
    @Autowired
    private IPurchaseService purchaseService;
    @PostMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public void insert(@RequestBody List<Integer> idPurchase) {
        purchaseService.create(idPurchase);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id) {
        purchaseService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<PurchaseDTO> buysList() {
        return purchaseService.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PurchaseDTO.class);}
        ).collect(Collectors.toList());
    }

    @GetMapping("/totalCompra")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<UserNameByTotalcompraByDateDTO> totalComprabyUser(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return purchaseService.findUserNameWithTotalcompraByWithDate(start,end).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserNameByTotalcompraByDateDTO.class);}
        ).collect(Collectors.toList());
    }
}
