package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Content;

import java.util.List;

@Repository
public interface IContentRepository extends JpaRepository<Content,Integer> {

    @Query("from Content c where c.libraryId.libraryName=:n")
    public List<Content> contentByLibraryName(@Param("n") String n);

    @Query("from Content c where c.libraryId.id=:d")
    public List<Content> contentByLibraryId(@Param("d") Integer d);

//    @Query("from Content c where c.")
//    public List<String[]> quantityContentByLibrary();
}
