package com.soccer.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.soccer.MainActivity;
import com.soccer.R;
import com.soccer.tools.Constants;
import com.soccer.tools.Preferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    MaterialButton login,SignUp;
    SignInButton gSignIn;
    private FirebaseAuth mAuth;
    EditText email_txt,password_txt;
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    String email,password;
    ProgressBar  bar;
    CallbackManager callbackManager;
    LoginButton loginButton;
    private static final String EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        callbackManager = CallbackManager.Factory.create();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
         bar= findViewById(R.id.bar);
        Sprite doubleBounce = new DoubleBounce();
        doubleBounce.setColor(getResources().getColor(R.color.bar));
        bar.setIndeterminateDrawable(doubleBounce);

        gSignIn=findViewById(R.id.signInButton);
        login=findViewById(R.id.SignInbtn);
        SignUp=findViewById(R.id.SignUpBtn);
        email_txt=findViewById(R.id.userEmailAddress);
        password_txt=findViewById(R.id.userPassword);

        findViewById(R.id.forgetpassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email_txt.getText().toString()!="" && password_txt.getText().toString()!="" ) {
                   bar.setVisibility(View.VISIBLE);
                    login(email_txt.getText().toString(), password_txt.getText().toString());
                }
                //startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        gSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bar.setVisibility(View.VISIBLE);
                signIn();
            }
        });




        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                AccessToken accessToken= loginResult.getAccessToken();
                if(accessToken!=null && !accessToken.isExpired()){

                    handleFacebookAccessToken(accessToken);

                }

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(LoginActivity.this, "Exception"+exception, Toast.LENGTH_SHORT).show();
            }
        });



    }
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("FACEBOOK", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FACEBOOK", "signInWithCredential:success");
                            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                            User myUserDetails = new User();
                            myUserDetails.name = firebaseAuth.getCurrentUser().getDisplayName();
                            myUserDetails.email = firebaseAuth.getCurrentUser().getEmail();

                            String photoUrl = firebaseAuth.getCurrentUser().getPhotoUrl().toString();
                            for (UserInfo profile : firebaseAuth.getCurrentUser().getProviderData()) {
                                System.out.println(profile.getProviderId());
                                // check if the provider id matches "facebook.com"
                                if (profile.getProviderId().equals("facebook.com")) {

                                    String facebookUserId = profile.getUid();

                                    photoUrl = "https://graph.facebook.com/" + facebookUserId + "/picture?type=normal";

                                }
                            }
                              myUserDetails.setPhoto(photoUrl+"");
                            DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child(Constants.USERS);
                            mDatabase.child(FirebaseAuth.getInstance().getUid()).setValue(myUserDetails).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finishAffinity();

                                }
                            });


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FACEBOOK", "signInWithCredential:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    public  void login(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            bar.setVisibility(View.GONE);

                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Login", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Preferences preferences= new Preferences(getApplicationContext());
                            preferences.setBoolean(Constants.LOGIN, true);
                            preferences.commit();

                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Login", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                        bar.setVisibility(View.GONE);

                        // ...
                    }
                });
    }


    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
             } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("gSignIn", "Google sign in failed", e);
                // [START_EXCLUDE]
                //updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("gSignIn", "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        //showProgressBar();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("gSignin", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Preferences preferences= new Preferences(getApplicationContext());
                            preferences.set(Constants.USERNAME,user.getDisplayName());
                            preferences.setBoolean(Constants.LOGIN, true);
                            preferences.commit();
                            bar.setVisibility(View.GONE);
                            User appuser= new User();
                            appuser.setEmail(user.getEmail()+"");
                            appuser.setName(user.getDisplayName()+"");
                            appuser.setPhoto(user.getPhotoUrl()+"");
                            appuser.setPhone(user.getPhoneNumber()+"");

                            DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child(Constants.USERS);
                            mDatabase.child(FirebaseAuth.getInstance().getUid()).setValue(appuser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finishAffinity();

                                }
                            });


                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("gSignIn", "signInWithCredential:failure", task.getException());
                            //Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signin]

}
