package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Library;
import pe.edu.upc.musictooltf.Exceptions.ResourceNotFoundException;
import pe.edu.upc.musictooltf.Repositories.ILibraryRepository;
import pe.edu.upc.musictooltf.Services.ILibraryService;

import java.util.List;

@Service
public class LibraryServiceImplement implements ILibraryService {

    @Autowired
    private ILibraryRepository libraryRepository;
    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library update(Library library, Integer id) {

        Library l = libraryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        l.setLibraryName(library.getLibraryName());
        l.setLibraryDescription(library.getLibraryDescription());
        l.setLibraryAvailable(library.getLibraryAvailable());
        l.setContents(library.getContents());
        l.setUsersId(library.getUsersId());

        return libraryRepository.save(l);
    }


    @Override
    public List<Library> list() {
        return libraryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public Library findbyId(Integer id) {
        return libraryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Library> findByLibraryAvailableAndLibraryName(Boolean available, String name) {
        return libraryRepository.findByLibraryAvailableAndLibraryName(available,name);
    }
}
