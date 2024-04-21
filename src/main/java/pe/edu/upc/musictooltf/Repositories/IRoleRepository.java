package pe.edu.upc.musictooltf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.musictooltf.Entities.Role;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    public List<Role> findByRoleName(String name);
}
