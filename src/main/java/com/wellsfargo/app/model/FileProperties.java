package com.wellsfargo.app.model;

import lombok.Data;

import java.util.List;

@Data
public class FileProperties {
    private List<String> allowedExtensions;
}
