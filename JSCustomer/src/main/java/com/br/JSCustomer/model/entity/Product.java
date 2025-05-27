package com.br.JSCustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productId;
    private String productDescription;
    private String productName;
    private String productQtd;
    private String productSize;
    private String sequence;
    private String storeId;
    private String price;
    private String productImage;
    private List<GroupItem> groupItems;

}
