package com.laplace.treats.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treat {
    
    private Integer id;
    private String name;
    private String type;
}
