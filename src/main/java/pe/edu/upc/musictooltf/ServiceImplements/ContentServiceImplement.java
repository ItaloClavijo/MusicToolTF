package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Content;
import pe.edu.upc.musictooltf.Repositories.IContentRepository;
import pe.edu.upc.musictooltf.Services.IContentService;

import java.util.List;

@Service
public class ContentServiceImplement implements IContentService {

    @Autowired
    private IContentRepository cR;

    @Override
    public void save(Content c) {
        cR.save(c);
    }
    @Override
    public void delete(Integer id) {
        cR.deleteById(id);
    }
    @Override
    public List<Content> listContent() {
        return cR.findAll();
    }
    @Override
    public List<Content> contentByLibraryName(String n) {
        return cR.contentByLibraryName(n);
    }
    @Override
    public List<Content> contentByLibraryId(Integer id) {
        return cR.contentByLibraryId(id);
    }

    @Override
    public List<String[]> totalCommentsByContent() {
        return cR.totalCommentsByContent();
    }

    @Override
    public List<String[]> saveContentInLibraries() {
        return cR.saveContentInLibraries();
    }

    @Override
    public List<String[]> quantityContentByArtist() {
        return cR.quantityContentByArtist();
    }
}