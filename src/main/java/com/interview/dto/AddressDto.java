package com.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {

    private Long id;
    private boolean active;
    private String address;
    private int addressType;

}
