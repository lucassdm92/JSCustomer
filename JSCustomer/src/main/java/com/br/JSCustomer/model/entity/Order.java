package com.br.JSCustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    private String orderId;
    private List<Product> listProduct;
    private BigDecimal totalAmount;
    private String orderStatus;
    private Customer customer;
    private Store store;
}
