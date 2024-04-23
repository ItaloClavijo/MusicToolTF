package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.ArtistDTO;
import pe.edu.upc.musictooltf.Entities.Artist;
import pe.edu.upc.musictooltf.Services.IArtistService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/artists")
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Artist save(@RequestBody @Validated ArtistDTO artistDTO){
        ModelMapper m = new ModelMapper();
        Artist a = m.map(artistDTO,Artist.class);
        return artistService.insert(a);
    }

    @GetMapping
    public List<ArtistDTO> list(){
        return artistService.list().stream().map(y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y,ArtistDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        artistService.delete(id);
    }

    @GetMapping("/{id}")
    public ArtistDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ArtistDTO artistDTO = m.map(artistService.findById(id),ArtistDTO.class);
        return artistDTO;
    }
}
