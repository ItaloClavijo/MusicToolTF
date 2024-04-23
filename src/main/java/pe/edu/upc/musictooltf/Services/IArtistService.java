package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.Entities.Artist;

import java.util.List;

public interface IArtistService {
    public Artist insert(Artist artist);

    public List<Artist> list();

    public void delete(Integer id);

    public Artist findById(Integer id);
}
