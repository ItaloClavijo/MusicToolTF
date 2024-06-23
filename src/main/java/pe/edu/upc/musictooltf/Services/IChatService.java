package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Chat;

import java.util.List;

public interface IChatService {
    public Chat create(Chat chat);
    public List<Chat> CHAT_LIST();
    public void Delete(Integer Id);

}
