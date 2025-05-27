package com.br.JSCustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String itemId;
    private String itemName;
    private String itemDescription;
    private Boolean isExtra;
    private String amount;
    private String productId;
    private String productImage;
}
