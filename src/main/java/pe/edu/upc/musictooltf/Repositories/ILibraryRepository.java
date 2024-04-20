package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Library;
import java.util.List;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, Integer> {
    public List<Library> findByLibraryAvailableAndLibraryName(Boolean available, String name);

}

