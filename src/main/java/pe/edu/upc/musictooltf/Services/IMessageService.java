package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Message;

import java.util.List;

public interface IMessageService {
    public Message create(Message message);
    public List<Message> MESSAGE_LIST();
    public void Delete(Integer Id);

}
