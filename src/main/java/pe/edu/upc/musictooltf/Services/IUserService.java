package pe.edu.upc.musictooltf.Services;

import jakarta.persistence.Id;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.musictooltf.Entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {

    public void insert(Users user);

    public List<Users> list();

    public void delete(Long idUser);

    public Users listId(Long idUser);

    public void update(Long idUser,Users user);

    public List<String[]> findUserNameWithTotalPurchaseByWithDate(LocalDate startDate, LocalDate finalDate);

    public Boolean existsUser(String username);
}
