package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Comentary;
import pe.edu.upc.musictooltf.Repositories.IComentaryRepository;
import pe.edu.upc.musictooltf.Services.IComentService;

import java.util.List;
@Service
public class ComentaryServiceImplement implements IComentService {

   @Autowired
   private IComentaryRepository comentaryRepository;

    @Override
    public Comentary create(Comentary coment) {
        return comentaryRepository.save(coment);
    }

    @Override
    public List<Comentary> COMENTARY_LIST() {
        return comentaryRepository.findAll();
    }

    @Override
    public void Delete(Integer Id) {
    comentaryRepository.deleteById(Id);
    }

    @Override
    public Comentary findById(Integer Id) {
        return comentaryRepository.findById(Id).orElseThrow();
    }
}
