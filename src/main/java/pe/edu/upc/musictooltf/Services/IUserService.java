package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.User;

import java.util.List;

public interface IUserService {

    public void insert(User user);

    public List<User> list();

    public void delete(Long idUser);

    public User listId(Long idUser);

}
