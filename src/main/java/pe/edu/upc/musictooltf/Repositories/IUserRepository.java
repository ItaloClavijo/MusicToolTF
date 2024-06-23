package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.musictooltf.Entities.Users;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    public Boolean existsByUsername(String username);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


    @Query(value = "SELECT u.username, p.date, SUM(p.purchase_total) as totalcompras \n" +
            "FROM purchase p JOIN users u ON p.user_id = u.id \n" +
            "WHERE p.date BETWEEN :startDate AND :finalDate \n" +
            "GROUP BY u.username, p.date ORDER BY  p.date ASC", nativeQuery = true)
    public List<String[]> findUserNameWithTotalPurchaseByWithDate(@Param("startDate")LocalDate startDate, @Param("finalDate") LocalDate finalDate);
}
