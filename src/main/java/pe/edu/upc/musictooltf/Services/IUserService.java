package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Users;

import java.util.List;

public interface IUserService {

    public void insert(Users user);

    public List<Users> list();

    public void delete(Long idUser);

    public Users listId(Long idUser);

}
