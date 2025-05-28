package com.br.JSCustomer.rest.api;

import com.br.JSCustomer.config.FireBaseConfigManager;
import com.br.JSCustomer.manager.IProductManager;
import com.br.JSCustomer.model.entity.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/sproduct")
@CrossOrigin(origins = "*")
public class ProductService {

    @Autowired
    private FireBaseConfigManager fireBaseConfigManager;
    @Autowired
    private IProductManager iProductManager;


    @GetMapping("/teste")
    public void teste() throws ExecutionException, InterruptedException {


     System.out.println("HAHA");
    }


    @GetMapping("/searchProductsByStoreId/{id}")
    public ResponseEntity<List<Product>> searchProductsByStoreId(@PathVariable("id") String id) throws ExecutionException, InterruptedException {


        CollectionReference product =
                fireBaseConfigManager
                        .getFireStoreInstance().collection("product_collection");
        Query query = product.whereEqualTo("storeId", id);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<Product> lista = new ArrayList<>();

        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            Product product2 = doc.toObject(Product.class);
            lista.add(product2);

        }

        return ResponseEntity.ok(lista);
    }


    @GetMapping("/creatProduct")
    public ResponseEntity<Product> creatProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {

        Product ProductSaved = iProductManager.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProductSaved);
    }
}
