package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Comentary;

@Repository
public interface IComentaryRepository extends JpaRepository<Comentary,Integer> {
}
