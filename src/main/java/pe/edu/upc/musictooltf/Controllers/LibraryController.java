package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.LibraryDTO;
import pe.edu.upc.musictooltf.Entities.Library;
import pe.edu.upc.musictooltf.Services.ILibraryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/libraries")
public class LibraryController {

    @Autowired
    private ILibraryService libraryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Library save(@RequestBody @Validated LibraryDTO libraryDTO){
        ModelMapper m = new ModelMapper();
        Library l = m.map(libraryDTO,Library.class);
        return libraryService.save(l);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public List<LibraryDTO> list(){
        return libraryService.list().stream().map(y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y,LibraryDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        libraryService.delete(id);
    }

    @GetMapping("/{id}")
    public LibraryDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        LibraryDTO libraryDTO=m.map(libraryService.findbyId(id),LibraryDTO.class);
        return libraryDTO;
    }
    @GetMapping("/find")
    public List<LibraryDTO> findDate(@RequestParam Boolean available , @RequestParam String name){
        return libraryService.findByLibraryAvailableAndLibraryName(available,name).stream().map(y->{
            ModelMapper m= new ModelMapper();
            return m.map(y,LibraryDTO.class);
        }).collect(Collectors.toList());
    }

}
