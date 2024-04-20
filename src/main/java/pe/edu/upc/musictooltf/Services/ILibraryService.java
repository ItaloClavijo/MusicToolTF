package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Library;

import java.util.List;

public interface ILibraryService {

    public Library save(Library library);

    public List<Library> list();

    public void delete (Integer id);

    public Library findbyId(Integer id);

    public List<Library> findByLibraryAvailableAndLibraryName(Boolean available, String name);

}
