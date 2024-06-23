package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.ContentDTO;
import pe.edu.upc.musictooltf.DTOs.QuantityContentByArtistDTO;
import pe.edu.upc.musictooltf.DTOs.SaveContentInLibraries;
import pe.edu.upc.musictooltf.DTOs.TotalCommentByContentDTO;
import pe.edu.upc.musictooltf.Entities.Content;
import pe.edu.upc.musictooltf.Services.IContentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/content")
public class ContentController {

    @Autowired
    private IContentService Cs;

    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    @GetMapping("/last")
    public List<ContentDTO> last() {
        return Cs.last().stream().map(
                y -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(y, ContentDTO.class);
                }
        ).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ContentDTO listId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        ContentDTO contentDTO=m.map(Cs.findById(id),ContentDTO.class);
        return contentDTO;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public void create(@RequestBody ContentDTO contentDTO) {
        ModelMapper m = new ModelMapper();
        Content c = m.map(contentDTO, Content.class);
        Cs.save(c);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public List<ContentDTO> list() {
        return Cs.listContent().stream().map(
                y -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(y, ContentDTO.class);
                }
        ).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public void delete(@PathVariable(name = "id") Integer id) {
        Cs.delete(id);
    }

    @GetMapping("/cantidadpornombre")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public List<ContentDTO> quantityContentByLibraryName(@RequestParam String n){
        return Cs.contentByLibraryName(n).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ContentDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadporid")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public List<ContentDTO> quantityContentByLibraryId(@RequestParam Integer id){
        return Cs.contentByLibraryId(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ContentDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/totalCommentByContent")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MELOMANO')")
    public List<TotalCommentByContentDTO> totalCommentByContent(){
        List<String[]> rowList = Cs.totalCommentsByContent();
        List<TotalCommentByContentDTO> dtoList= new ArrayList<>();

        for(String[] column : rowList) {
            TotalCommentByContentDTO dto = new TotalCommentByContentDTO();
            dto.setNameContent(column[0]);
            dto.setTotalComent(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/saveContentInLibraries")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MELOMANO')")
    public List<SaveContentInLibraries> saveContentInLibraries(){
        List<String[]> rowList = Cs.saveContentInLibraries();
        List<SaveContentInLibraries> dtoList= new ArrayList<>();

        for(String[] column : rowList) {
            SaveContentInLibraries dto = new SaveContentInLibraries();
            dto.setNameLibrary(column[0]);
            dto.setCountSave(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/quantityContentByArtist")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MELOMANO')")
    public List<QuantityContentByArtistDTO> quantityContentByArtist(){
        List<String[]> rowList = Cs.quantityContentByArtist();
        List<QuantityContentByArtistDTO> dtoList= new ArrayList<>();

        for(String[] column : rowList) {
            QuantityContentByArtistDTO dto = new QuantityContentByArtistDTO();
            dto.setNameArtist(column[0]);
            dto.setQuantityContent(Integer.parseInt(column[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

}