package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.DocumentRepository;
import com.proline.OsErpProline.Service.DocumentStorageService;
import com.proline.OsErpProline.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;

@RestController
public class DocumentController {
    private DocumentRepository documentRepository;

    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


}
