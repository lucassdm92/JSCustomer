package com.br.JSCustomer.manager;

import com.br.JSCustomer.model.entity.GroupItem;
import com.br.JSCustomer.model.entity.Item;
import com.br.JSCustomer.model.entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductManager implements IProductManager {


    @Override
    public Product createProduct(Product product) {
        Firestore db = FirestoreClient.getFirestore();

        String productId = db.collection("product_collection").document().getId();
        product.setProductId(productId);

        if (product.getGroupItems() != null) {
            for (GroupItem groupItem : product.getGroupItems()) {
                if (groupItem.getItemList() != null) {
                    for (Item item : groupItem.getItemList()) {
                        String itemId = UUID.randomUUID().toString(); // ou db.collection("...").document().getId()
                        item.setItemId(itemId);
                        item.setProductId(productId); // referenciar o produto pai
                    }
                }
            }
        }

        db.collection("product_collection").document(productId).set(product);


        return product;
    }
}
