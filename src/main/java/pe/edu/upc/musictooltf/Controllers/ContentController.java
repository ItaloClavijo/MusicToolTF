package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.ContentDTO;
import pe.edu.upc.musictooltf.Entities.Content;
import pe.edu.upc.musictooltf.Services.IContentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/content")
public class ContentController {

    @Autowired
    private IContentService Cs;

    @PostMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public void create(@RequestBody ContentDTO contentDTO) {
        ModelMapper m = new ModelMapper();
        Content c = m.map(contentDTO, Content.class);
        Cs.save(c);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<ContentDTO> list() {
        return Cs.listContent().stream().map(
                y -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(y, ContentDTO.class);
                }
        ).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public void delete(@PathVariable(name = "id") Integer id) {
        Cs.delete(id);
    }

    @GetMapping("/cantidadpornombre")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<ContentDTO> quantityContentByLibraryName(@RequestParam String n){
        return Cs.contentByLibraryName(n).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ContentDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadporid")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public List<ContentDTO> quantityContentByLibraryId(@RequestParam Integer id){
        return Cs.contentByLibraryId(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ContentDTO.class);
        }).collect(Collectors.toList());
    }

}