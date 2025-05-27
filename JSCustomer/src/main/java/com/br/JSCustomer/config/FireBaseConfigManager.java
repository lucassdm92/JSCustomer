package com.br.JSCustomer.config;

import com.br.JSCustomer.rest.api.OrderServices;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireBaseConfigManager {


    private static final Logger logger = LoggerFactory.getLogger(OrderServices.class);

    @PostConstruct
    public void initialize() throws IOException {

        logger.debug("Iniciou o metodo de firebase");
//        InputStream serviceAccount = getClass()
        //              .getClassLoader()
        //      .getResourceAsStream("jfood-4c3be-firebase-adminsdk-ltl00-7d35246665.json");

        //logger.debug("Arquivo "+serviceAccount);

        // if (serviceAccount == null) {
        //   throw new IOException("Arquivo de credenciais Firebase não encontrado no classpath.");
        //}

        logger.debug("Credencial "+GoogleCredentials.getApplicationDefault());
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
        logger.debug("Credencial  2"+GoogleCredentials.getApplicationDefault());


        FirebaseApp.initializeApp(options);
        logger.debug("Credencial INIT");

    }


    @Bean
    public Firestore getFireStoreInstance() {
        return FirestoreClient.getFirestore();
    }
}
