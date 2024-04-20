package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Content;

import java.util.List;

public interface IContentService {
    public void save(Content c);
    public void delete(Integer id);
    public List<Content> listContent();
    public List<Content> contentByLibraryName(String n);
    public List<Content> contentByLibraryId(Integer id);
}
