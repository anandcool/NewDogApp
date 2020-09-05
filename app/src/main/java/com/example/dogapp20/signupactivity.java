package com.example.dogapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dogapp20.commonClasses.URL;

import java.util.HashMap;
import java.util.Map;

public class signupactivity extends AppCompatActivity {

    EditText uname, pass, pno, mail;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        pno = findViewById(R.id.pno);
        mail = findViewById(R.id.mail);
        btnsignup = findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(uname.getText().toString(), pass.getText().toString(), pno.getText().toString(), mail.getText().toString());
            }
        });
    }

    private void registerUser(final String uname, final String pass,final String pno, final String mail) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(signupactivity.this, ""+response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",uname);
                params.put("email",mail);
                params.put("pass",pass);
                params.put("pno",pno);
                return params; // {email: 'shivnag@gmail.com',pass:'124'}
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
//        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}
