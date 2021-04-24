package local.snk.fileservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileController {
    @GetMapping("/size")
    public ResponseEntity<local.snk.fileservice.File> getFileSize(@RequestParam(value = "fileName") String fileName) {
        File file = new File(fileName);
        if(file.exists() && file.isFile()) {
            try {
                return ResponseEntity.ok(new local.snk.fileservice.File(fileName, Files.size(Paths.get(fileName))));
            } catch (IOException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get file size.", ex);
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found.");
    }
}
