package com.example.welcome;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
   EditText u,p;
   Button b,b1;
   private  FirebaseAuth auth;
   FirebaseFirestore fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       u=findViewById(R.id.user);
       p=findViewById(R.id.pass);
       b=findViewById(R.id.button);
       b1=findViewById(R.id.button1);
       auth=FirebaseAuth.getInstance();
       fb=FirebaseFirestore.getInstance();
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name=u.getText().toString().trim();
               String poss=p.getText().toString().trim();
              /* auth.createUserWithEmailAndPassword(name,poss).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                   @Override
                   public void onSuccess(AuthResult authResult) {
                       Toast.makeText(MainActivity.this, "Welocome", Toast.LENGTH_SHORT).show();
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });
*/
              User user=new User(name,poss);
              fb.collection("User").document("new")
                      .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                      if(task.isSuccessful())
                      {
                          Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                      }
                  }
              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                  }
              });
           }
       });
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=u.getText().toString().trim();
            String poss=p.getText().toString().trim();
            auth.signInWithEmailAndPassword(name,poss).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(MainActivity.this, "Thanku", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    });
    }

}
