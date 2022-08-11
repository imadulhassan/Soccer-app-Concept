package com.soccer.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.soccer.MainActivity;
import com.soccer.R;
import com.soccer.tools.Constants;
import com.soccer.tools.Preferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    MaterialButton SignUp;
    EditText email_txt,password_txt,name_txt,phn_txt;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    ProgressBar bar;

    String email,pass,name,phn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference().child(Constants.USERS);
        bar= findViewById(R.id.bar);
        Sprite doubleBounce = new DoubleBounce();
        doubleBounce.setColor(getResources().getColor(R.color.bar));
        bar.setIndeterminateDrawable(doubleBounce);


        SignUp=findViewById(R.id.userSignUp);
        email_txt=findViewById(R.id.userEmailAddress);
        password_txt=findViewById(R.id.userPassword);
        name_txt=findViewById(R.id.userNametxt);
        phn_txt=findViewById(R.id.userPhntxt);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=email_txt.getText().toString();
                pass=password_txt.getText().toString();
                name=name_txt.getText().toString();
                phn=phn_txt.getText().toString();
                if(email_txt.getText().toString()!="" && password_txt.getText().toString()!="" ) {
                    bar.setVisibility(View.VISIBLE);
                    SignUp(name,email,pass,phn);
                }
                //startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }
    public  void SignUp(final String uname, final String email, String password, final String phone){
        final User user = new User(uname, phone, email);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        bar.setVisibility(View.GONE);


                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SignUp", "signUpWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();

                            String userId=mAuth.getCurrentUser().getUid();
                            mDatabase.child(userId).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Preferences preferences= new Preferences(getApplicationContext());
                                    preferences.set(Constants.USERNAME,uname);
                                    preferences.set(Constants.EMIAL,email);
                                    preferences.set(Constants.PHONE,phone);
                                    preferences.commit();
                                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                                    finishAffinity();

                                }
                            });


                        } else {
                            // If sign in fails, display a message to the user.
                            bar.setVisibility(View.GONE);

                            Log.w("SignUp", "signUpWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}
