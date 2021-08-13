package com.proline.OsErpProline.Service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentStorageService {
    public void save(MultipartFile file);
}
