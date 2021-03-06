package com.ckrprojects.clinicallabtransactions.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequiredFieldNotFoundException extends RuntimeException {

    private String field;

}
