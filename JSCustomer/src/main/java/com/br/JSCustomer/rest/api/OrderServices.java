package com.br.JSCustomer.rest.api;

import com.br.JSCustomer.config.FireBaseConfigManager;
import com.br.JSCustomer.manager.IOrderManager;
import com.br.JSCustomer.model.entity.Order;
import com.br.JSCustomer.model.entity.Product;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sorder")
@CrossOrigin(origins = "*")
public class OrderServices {


    @Autowired
    private IOrderManager orderManager;

    private static final Logger logger = LoggerFactory.getLogger(OrderServices.class);

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order orderResponse = orderManager.pushOrderToRestaurante(order);

        return ResponseEntity.ok(orderResponse);

    }
}
