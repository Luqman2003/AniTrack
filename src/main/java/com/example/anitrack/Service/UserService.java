package com.example.anitrack.Service;

import com.example.anitrack.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.Locked;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public String createUser(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user").document(user.getDocumentId()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String document_id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("user").document(document_id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user;
        if (document.exists()) {
            user = document.toObject(User.class);
            return user;
        }
        return null;
    }

    public String updateUser(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user").document(user.getDocumentId()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUser(String document_id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("user").document(document_id).delete();
        return "Successfully deleted " + document_id;
    }
}
