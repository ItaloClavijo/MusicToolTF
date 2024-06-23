package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.MessageDTO;
import pe.edu.upc.musictooltf.Entities.Message;
import pe.edu.upc.musictooltf.Services.IMessageService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    @Autowired
    private IMessageService Ms;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAuthority('MELOMANO')")
    public void save(@RequestBody @Validated MessageDTO messageDTO) {
        ModelMapper m = new ModelMapper();
        Message message = m.map(messageDTO, Message.class);
        Ms.create(message);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('MELOMANO')")
    public List<MessageDTO> messageList() {
        return Ms.MESSAGE_LIST().stream().map(y->{
            ModelMapper n = new ModelMapper();
            return n.map(y,MessageDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('MELOMANO')")
    public void Delete(@PathVariable("id")Integer Id){
        Ms.Delete(Id);
    }



}
