package com.example.anitrack;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class AniTrackApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader classloader = AniTrackApplication.class.getClassLoader();

        File file = new File(Objects.requireNonNull(classloader.getResource("serviceAccountKey.json")).getFile());
        FileInputStream serviceAccount =
                new FileInputStream(file.getAbsolutePath());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://miruku-9e485-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

        SpringApplication.run(AniTrackApplication.class, args);
    }

}
