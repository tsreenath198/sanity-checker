package com.wellsfargo.app.validator;

import com.wellsfargo.app.exception.ValidateException;
import com.wellsfargo.app.mail.NotificationService;
import com.wellsfargo.app.model.FileProperties;
import com.wellsfargo.app.model.LocationProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

@Component
public class FileSanityValidator {

    @Autowired
    private LocationProperties locationProperties;

    @Autowired
    private LZFileValidator lzFileValidator;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private FileProperties fileProperties;


    public void validateAll() throws IOException {
        File[] fileList = new File(locationProperties.getSourceDir()).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return fileProperties.getAllowedExtensions().contains(FilenameUtils.getExtension(file.getName()));
            }
        });
        for(File file : fileList) {
            try{
                lzFileValidator.validateFile(file);
                FileUtils.moveFileToDirectory(file, new File(locationProperties.getArchiveDir()), false);
            }catch(ValidateException e){
                //notificationService.sendErrorNotification(file, e.getMessage());
                FileUtils.moveFileToDirectory(file, new File(locationProperties.getFailDir()), false);
            }
        }
    }
}
