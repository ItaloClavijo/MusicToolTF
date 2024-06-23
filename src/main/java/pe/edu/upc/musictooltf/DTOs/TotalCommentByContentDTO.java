package pe.edu.upc.musictooltf.DTOs;

public class TotalCommentByContentDTO {
    private String nameContent;

    private Integer totalComment;

    public String getNameContent() {
        return nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public Integer getTotalComent() {
        return totalComment;
    }

    public void setTotalComent(Integer totalComent) {
        this.totalComment = totalComent;
    }
}
