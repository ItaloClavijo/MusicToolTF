package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.ChatDTO;
import pe.edu.upc.musictooltf.Entities.Chat;

import pe.edu.upc.musictooltf.Services.IChatService;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("musictool/chats")
public class ChatController {

    @Autowired
    private IChatService chatService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAuthority('MELOMANO')")
    public Chat save(@RequestBody @Validated ChatDTO chatDTO) {
        ModelMapper m = new ModelMapper();
        Chat chat = m.map(chatDTO, Chat.class);
        return chatService.create(chat);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('MELOMANO')")
    public List<ChatDTO> chatList() {
        return chatService.CHAT_LIST().stream().map(y->{
            ModelMapper n = new ModelMapper();
            return n.map(y,ChatDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('MELOMANO')")
    public void Delete(@PathVariable("id")Integer Id){
        chatService.Delete(Id);
    }

}
