package com.teammansasung.careerbookapi.api.user;

import com.teammansasung.careerbookapi.config.auth.LoginUser;
import com.teammansasung.careerbookapi.config.auth.dto.SessionUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    @PostMapping("/user/file")
    public ResponseEntity<?> uploadFile(@LoginUser SessionUser user, @RequestParam MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            File tmpFile = new File("C:\\test", file.getOriginalFilename());
            file.transferTo(tmpFile);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/file")
    public String getProfile(@LoginUser SessionUser user) {
        return null;
    }
}
