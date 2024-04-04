package com.airgear.model.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomEmailStructure {
    private String to;
    private String subject;
    private String text;
    private String attachment;
}
