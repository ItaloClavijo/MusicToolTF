package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Message;
import pe.edu.upc.musictooltf.Repositories.IMessageRepository;
import pe.edu.upc.musictooltf.Services.IMessageService;

import java.util.List;

@Service
public class MessageServiceImplement implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;


    @Override
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> MESSAGE_LIST() {
        return messageRepository.findAll();
    }

    @Override
    public void Delete(Integer Id) {
        messageRepository.deleteById(Id);
    }

    @Override
    public Message findById(Integer Id) {
        return messageRepository.findById(Id).orElseThrow();
    }
}
