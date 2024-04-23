package pe.edu.upc.musictooltf.DTOs;

public class UploadMediaResponse {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UploadMediaResponse(String path) {
        this.path = path;
    }
}
