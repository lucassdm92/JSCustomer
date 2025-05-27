package com.br.JSCustomer.rest.api;


import com.br.JSCustomer.model.entity.Product;
import com.br.JSCustomer.model.entity.Store;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/sservices")
@CrossOrigin(origins = "*")
public class StoreServices {

    @GetMapping("/getAllStore")
    public ResponseEntity<List<Store>> getAllStore() throws IOException, ExecutionException, InterruptedException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference stores = db.collection("store_collection");

        ApiFuture<QuerySnapshot> query = stores.get();
        List<QueryDocumentSnapshot> documents = query.get().getDocuments();


        StringBuilder sb = new StringBuilder();

        List<Store> result = new ArrayList<>();
        for (DocumentSnapshot doc : documents) {
            Store store = doc.toObject(Store.class);
            assert store != null;
            store.setStoreId(doc.getId());

            result.add(store);  // pegando os dados do documento como Map
        }


        return ResponseEntity.ok(result);
    }
}
