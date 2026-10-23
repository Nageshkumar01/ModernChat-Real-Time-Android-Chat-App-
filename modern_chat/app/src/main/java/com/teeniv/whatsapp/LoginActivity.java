package com.teeniv.whatsapp;
import android.content.Intent;import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;import com.google.firebase.auth.FirebaseAuth;
public class LoginActivity extends AppCompatActivity {
 FirebaseAuth auth;
 @Override protected void onCreate(Bundle b){super.onCreate(b);auth=FirebaseAuth.getInstance();if(auth.getCurrentUser()!=null){openHome();return;}setContentView(R.layout.activity_login);
 EditText email=findViewById(R.id.email),password=findViewById(R.id.password);findViewById(R.id.loginButton).setOnClickListener(v->{String e=email.getText().toString().trim(),p=password.getText().toString();if(e.isEmpty()||p.isEmpty()){toast("Enter your email and password");return;}auth.signInWithEmailAndPassword(e,p).addOnSuccessListener(r->openHome()).addOnFailureListener(x->toast(x.getLocalizedMessage()));});findViewById(R.id.registerLink).setOnClickListener(v->startActivity(new Intent(this,RegisterActivity.class)));}
 void openHome(){startActivity(new Intent(this,HomeActivity.class));finish();}void toast(String s){Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
