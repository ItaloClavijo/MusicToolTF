package pe.edu.upc.musictooltf.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.musictooltf.DTOs.UploadMediaResponse;
import pe.edu.upc.musictooltf.Services.StorageService;

import java.io.IOException;
import java.nio.file.Files;

@RequestMapping("/musictool/mediastorage")
@RestController
public class MediaController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public UploadMediaResponse upload(@RequestParam("file") MultipartFile multipartFile) {
        String path = storageService.store(multipartFile);
        return new UploadMediaResponse(path);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getResource(@PathVariable String fileName) throws IOException {
        Resource resource = storageService.loadAsResource(fileName);
        String contentType = Files.probeContentType(resource.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);
    }
}

