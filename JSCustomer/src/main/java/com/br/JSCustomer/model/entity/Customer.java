package com.br.JSCustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;
    private String customerLongitude;
    private String customerLatitude;
    private Boolean isActive;

}
