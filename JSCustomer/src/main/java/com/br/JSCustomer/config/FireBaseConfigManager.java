package com.br.JSCustomer.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireBaseConfigManager {

    @PostConstruct
    public void initialize() throws IOException {

        InputStream serviceAccount = getClass()
                .getClassLoader()
                .getResourceAsStream("jfood-4c3be-firebase-adminsdk-ltl00-7d35246665.json");

        if (serviceAccount == null) {
            throw new IOException("Arquivo de credenciais Firebase não encontrado no classpath.");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://jfood-4c3be-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

    }


    @Bean
    public Firestore getFireStoreInstance() {
        return FirestoreClient.getFirestore();
    }
}
