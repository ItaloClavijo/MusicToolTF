package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Purchase;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value ="SELECT u.username, p.date, SUM(p.purchase_total) as totalcompras \n" +
            "FROM Purchase p \n" +
            "JOIN Users u ON p.user_id = u.id \n" +
            "WHERE p.date BETWEEN :fechaInicio AND :fechaFin \n" +
            "GROUP BY u.username, p.date \n" +
            "ORDER BY  p.date ASC",nativeQuery = true)
    public List<String[]> findUserNameWithTotalcompraByWithDate(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin")  LocalDate fechaFin);
}
