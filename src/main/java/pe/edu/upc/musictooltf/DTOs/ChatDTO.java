package pe.edu.upc.musictooltf.DTOs;
import java.time.LocalDate;

public class ChatDTO {
    private Integer idChat;


    private String chatContent;

    private LocalDate chatDate;

    private int contentId;

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public LocalDate getChatDate() {
        return chatDate;
    }

    public void setChatDate(LocalDate chatDate) {
        this.chatDate = chatDate;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
}
