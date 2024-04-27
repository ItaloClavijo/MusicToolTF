package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.PurchaseContentDTO;
import pe.edu.upc.musictooltf.Entities.PurchaseContent;
import pe.edu.upc.musictooltf.Services.IPurchaseContentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/purchaseContent")
public class PurchaseContentController {
    @Autowired
    private IPurchaseContentService purchaseContentService;

    @PostMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public void insert(@RequestBody PurchaseContentDTO purchaseContentDTO) {
        ModelMapper m = new ModelMapper();
        PurchaseContent purchaseContent = m.map(purchaseContentDTO, PurchaseContent.class);
        purchaseContentService.insert(purchaseContent);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id) {
        purchaseContentService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<PurchaseContentDTO> buyContentList() {
        return purchaseContentService.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PurchaseContentDTO.class);}
        ).collect(Collectors.toList());
    }
}
