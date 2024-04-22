package pe.edu.upc.musictooltf.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.ComentaryDTO;
import pe.edu.upc.musictooltf.Entities.Comentary;
import pe.edu.upc.musictooltf.Services.IComentService;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("musictool/comentary")
public class ComentaryController {
    @Autowired
    private IComentService comentaryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody @Validated ComentaryDTO comentaryDTO) {
        ModelMapper m = new ModelMapper();
        Comentary comentary = m.map(comentaryDTO, Comentary.class);
        comentaryService.create(comentary);
    }

    @GetMapping
    public List<ComentaryDTO> comentariosList() {
        return comentaryService.COMENTARY_LIST().stream().map(y->{
            ModelMapper n = new ModelMapper();
            return n.map(y,ComentaryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id")Integer Id){
        comentaryService.Delete(Id);
    }

    @GetMapping("/{id}")
    public ComentaryDTO listId(@PathVariable("id")Integer Id){
         ModelMapper m =new ModelMapper();
         ComentaryDTO cdto=m.map(comentaryService.findById(Id), ComentaryDTO.class);
         return cdto;
    }


}
