package com.wellsfargo.app.validator;

import com.wellsfargo.app.exception.ValidateException;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LZFileValidator {

    public void validateFile(File file) throws ValidateException {
        // TODO : The logic to validate the file will go here
        throw new ValidateException("Invalid file");
    }
}
