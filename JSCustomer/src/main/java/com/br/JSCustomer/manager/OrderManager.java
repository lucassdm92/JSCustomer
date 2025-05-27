package com.br.JSCustomer.manager;

import com.br.JSCustomer.config.FireBaseConfigManager;
import com.br.JSCustomer.model.entity.Order;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class OrderManager implements IOrderManager {

    @Autowired
    private FireBaseConfigManager fireBaseConfigManager;


    /**
     * @return Order
     */
    @Override
    public Order pushOrderToRestaurante(Order order) {


        ApiFuture<WriteResult> response = fireBaseConfigManager
                .getFireStoreInstance()
                .collection("order_collection")
                .document().set(order);

        try {
            response.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        return order;
    }
}