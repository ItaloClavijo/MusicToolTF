package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.musictooltf.Entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.userName) from User u where u.userName =:username")
    public int buscarUsername(@Param("userName") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}
