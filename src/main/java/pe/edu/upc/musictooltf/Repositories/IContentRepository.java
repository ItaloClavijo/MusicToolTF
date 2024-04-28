package pe.edu.upc.musictooltf.Repositories;

import jakarta.validation.Valid;
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

    @Query(value = "SELECT c.title_content, COUNT(cm.id_coment) as totalComentarios \n" +
            "FROM Comentary cm JOIN Content c \n" +
            "ON cm.content_id = c.id_content \n" +
            "GROUP BY c.title_content \n" +
            "ORDER BY totalComentarios ASC", nativeQuery = true)
    public List<String[]> totalCommentsByContent();

    @Query(value = "SELECT l.library_name AS Bibliotecas, COUNT(c.library_id) AS cantidad_guardado \n" +
            "FROM library l \n" +
            "JOIN content c  ON l.id = c.library_id \n" +
            "GROUP BY l.library_name", nativeQuery = true)
    public List<String[]> saveContentInLibraries();

    @Query(value = "SELECT a.name AS nombre_artista, COUNT(c.id_content) AS cantidad_contenido \n" +
            "FROM artist a \n" +
            "JOIN content c ON a.id_artist = c.artist_id \n" +
            "GROUP BY a.name", nativeQuery = true)
    public List<String[]> quantityContentByArtist();
}
