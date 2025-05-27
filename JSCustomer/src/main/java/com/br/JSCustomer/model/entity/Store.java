package com.br.JSCustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private String category;
    private String storeDescription;
    private String storeLocation;
    private String storeName;
    private String storeUrladdressImage;
    private String storeId;
}
