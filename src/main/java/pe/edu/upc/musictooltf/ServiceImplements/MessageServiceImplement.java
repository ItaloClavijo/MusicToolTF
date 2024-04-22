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
        return null;
    }

    @Override
    public List<Message> MESSAGE_LIST() {
        return null;
    }

    @Override
    public void Delete(Integer Id) {

    }

    @Override
    public Message findById(Integer Id) {
        return null;
    }

    @Override
    public void save(Message c) {

    }

    @Override
    public void delete(Integer id) {

    }
}
