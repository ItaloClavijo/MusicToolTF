package pe.edu.upc.musictooltf.Services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {

    void init();

    String store(MultipartFile file);

    //Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    // void deleteAll();

    void delete(String fileName);

}
