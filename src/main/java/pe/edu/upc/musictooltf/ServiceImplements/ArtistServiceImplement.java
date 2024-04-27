package pe.edu.upc.musictooltf.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.Entities.Artist;
import pe.edu.upc.musictooltf.Repositories.IArtistRepository;
import pe.edu.upc.musictooltf.Services.IArtistService;

import java.util.List;

@Service
public class ArtistServiceImplement implements IArtistService {

    @Autowired
    private IArtistRepository artistRepository;

    @Override
    public Artist insert(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> list() {
        return artistRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist findById(Integer id) {
        return artistRepository.findById(id).orElseThrow();
    }
}
