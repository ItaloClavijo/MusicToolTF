package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Comentary;
import java.util.List;

public interface IComentService {
    public Comentary create(Comentary coment);
    public List<Comentary> COMENTARY_LIST();
    public void Delete(Integer Id);
public Comentary findById(Integer Id);
}
