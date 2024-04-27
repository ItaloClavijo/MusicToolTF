package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Library;
import pe.edu.upc.musictooltf.Entities.Users;
import pe.edu.upc.musictooltf.Repositories.IUserRepository;
import pe.edu.upc.musictooltf.Services.IUserService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(Users user) {
        user.setRegisterDate(LocalDate.now());
        uR.save(user);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Users listId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }
}