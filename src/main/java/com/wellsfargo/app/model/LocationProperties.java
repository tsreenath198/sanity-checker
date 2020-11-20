package com.wellsfargo.app.model;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.io.File;

@Data
public class LocationProperties {
    private String rootDir;
    private String sourceDir;
    private String failDir;
    private String archiveDir;

    @PostConstruct
    public void validateDirectories() {
        if (!(rootDir != null && new File(rootDir).exists() && new File(rootDir).isDirectory())) {
            throw new RuntimeException("Invalid Root Directory : " + rootDir);
        }
        if (!(sourceDir != null && new File(sourceDir).exists() && new File(sourceDir).isDirectory())) {
            throw new RuntimeException("Invalid Source Directory" + sourceDir);
        }
        if (!(failDir != null && new File(failDir).exists() && new File(failDir).isDirectory())) {
            throw new RuntimeException("Invalid Fail Directory" + failDir);
        }
        if (!(archiveDir != null && new File(archiveDir).exists() && new File(archiveDir).isDirectory())){
            throw new RuntimeException("Invalid Archive Directory" + archiveDir);
        }
    }
}
