package com.br.JSCustomer.manager;

import com.br.JSCustomer.model.entity.Order;

public interface IOrderManager {

    Order pushOrderToRestaurante(Order order);
}
