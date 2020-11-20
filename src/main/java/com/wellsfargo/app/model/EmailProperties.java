package com.wellsfargo.app.model;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@Data
public class EmailProperties {
    private String fromEmail;
    private String subjectTemplate;
    private String bodyTemplate;
    private List<String> toEmails;
    private List<String> ccEmails;
    private List<String> bccEmails;
}
