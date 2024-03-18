package com.fakestore.product.ExceptionHandling;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Setter
//@Builder
@Data
//@NoArgsConstructor
public class ErrorMessage {
    private String message;
    private Date occuredAt;
    private String description;
}
