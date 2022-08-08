package com.example.appenea.login

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R

class MongoDbActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        /*

        Realm uiThreadRealm;
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        MongoCollection<Document> mongoCollection;
        User user;
        App app;
        String AppId = YOUR APP ID FROM REALM UI";

        app = new App(new AppConfiguration.Builder(AppId).build());

        if (app.currentUser() == null) {
            Toast.makeText(this, "user is null", Toast.LENGTH_SHORT).show();
            app.loginAsync(Credentials.anonymous(), new App.Callback<User>() {
                @Override
                public void onResult(App.Result<User> result) {
                    if (result.isSuccess()) {
                        Log.v("User", "Logged In Successfully");
                        initializeMongoDB();
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                    } else {
                        Log.v("User", "Failed to Login");
                        Toast.makeText(MainActivity.this, "Failed to login", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "user is not null", Toast.LENGTH_SHORT).show();
            initializeMongoDB();
        }

        private void initializeMongoDB() {
            user = app.currentUser();
            mongoClient = user.getMongoClient("mongodb-atlas");
            mongoDatabase = mongoClient.getDatabase("YOUR DATABASE NAME");
            mongoCollection = mongoDatabase.getCollection("YOUR COLLECTION NAME");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user == null)
                    user = app.currentUser();

                Document document = new Document().append("Name", b.name.getText().toString()).append("myid", "1234").append("userId", user.getId());
                mongoCollection.insertOne(document).getAsync(result -> {
                if (result.isSuccess()) {
//                        BsonObjectId insertedId = result.get().getInsertedId().asObjectId();
//                        Log.v("adding", "result");
                    Toast.makeText(MainActivity.this, "Inserted successfully", Toast.LENGTH_LONG).show();
                } else {
//                        Log.v("adding", "result failed" + result.getError().toString());
                    Toast.makeText(MainActivity.this, "Error " + result.getError(), Toast.LENGTH_LONG).show();
                }
            });
            }
        });

         */

    }




}