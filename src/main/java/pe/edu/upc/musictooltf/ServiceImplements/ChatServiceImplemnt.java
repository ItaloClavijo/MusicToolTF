package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Chat;
import pe.edu.upc.musictooltf.Repositories.IChatRepository;
import pe.edu.upc.musictooltf.Services.IChatService;

import java.util.List;

@Service
public class ChatServiceImplemnt implements IChatService {

    @Autowired
    private IChatRepository chatRepository;

    @Override
    public Chat create(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> CHAT_LIST() {
        return chatRepository.findAll();
    }

    @Override
    public void Delete(Integer Id) { chatRepository.deleteById(Id); }

}
