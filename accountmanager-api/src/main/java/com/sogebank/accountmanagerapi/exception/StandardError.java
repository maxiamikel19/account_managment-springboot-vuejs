package com.sogebank.accountmanagerapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    
    private String message;
    private Integer status;
}
