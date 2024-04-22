package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.MessageDTO;
import pe.edu.upc.musictooltf.Entities.Message;
import pe.edu.upc.musictooltf.Services.IMessageService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/message")
public class MessageController {

    @Autowired
    private IMessageService Ms;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody @Validated MessageDTO messageDTO) {
        ModelMapper m = new ModelMapper();
        Message message = m.map(messageDTO, Message.class);
        Ms.create(message);
    }

    @GetMapping
    public List<MessageDTO> messageList() {
        return Ms.MESSAGE_LIST().stream().map(y->{
            ModelMapper n = new ModelMapper();
            return n.map(y,MessageDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id")Integer Id){
        Ms.Delete(Id);
    }

    @GetMapping("/{id}")
    public MessageDTO listId(@PathVariable("id")Integer Id){
        ModelMapper m =new ModelMapper();
        MessageDTO mdto=m.map(Ms.findById(Id), MessageDTO.class);
        return mdto;
    }
}
