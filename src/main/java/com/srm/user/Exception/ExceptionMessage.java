package com.srm.user.Exception;

import lombok.Data;

@Data
public class ExceptionMessage {

    private String message;
    private String error;
    private String path;
    private String code;
}
