package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Chat;
import pe.edu.upc.musictooltf.Services.IChatService;

import java.util.List;

@Service
public class ChatServiceImplemnt implements IChatService {

    @Override
    public Chat create(Chat chat) {
        return null;
    }

    @Override
    public List<Chat> CHAT_LIST() {
        return null;
    }

    @Override
    public void Delete(Integer Id) {

    }

    @Override
    public Chat findById(Integer Id) {
        return null;
    }
}
