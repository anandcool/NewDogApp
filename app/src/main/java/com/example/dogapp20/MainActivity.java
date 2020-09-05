package com.example.dogapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.dogapp20.UserSide.Profile;
import com.example.dogapp20.commonClasses.SharedData;
import com.example.dogapp20.commonClasses.URL;
import com.example.dogapp20.userClasses.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText moblogin,passlogin;
    Button btnlogin,btnjoin;
    SharedData sp;
    final String SHARED_PREF_NAME = "mysharedpref";
    final String KEY_NAME = "keyname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moblogin = findViewById(R.id.phone);
        passlogin = findViewById(R.id.passlogin);
        btnjoin = findViewById(R.id.btnjoin);
        btnlogin = findViewById(R.id.btnlogin);
        sp = new SharedData(getApplicationContext());
        if(sp.GetSharedPrefernce()){
            startActivity(new Intent(MainActivity.this,Profile.class));

        }
        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),signupactivity.class);
                startActivity(in);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LoginUser(moblogin.getText().toString(),passlogin.getText().toString(),MainActivity.this);
            Intent in = new Intent(getApplicationContext(),Profile.class);
            startActivity(in);
            }
        });
    }

    private void LoginUser(final String mobile, final String pass, final Context mctx) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if(!jsonObject.getBoolean("error")){

                        JSONArray jsonArray = jsonObject.getJSONArray("user");
                        JSONObject obj = jsonArray.getJSONObject(0);
                        User user = new User(obj.getString("uname"),obj.getString("email"),obj.getString("pass"),obj.getString("pno"));
//                        Log.d("user",user.getEmail());
                        sp = new SharedData(getApplicationContext());
                        sp.SaveSharedPrefernce(mobile,pass); //save the data in sharedprefernces
                        Intent in = new Intent(MainActivity.this, Profile.class);
                        in.putExtra("user",user);
                        startActivity(in);
                        Toast.makeText(MainActivity.this, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(mctx, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mctx, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("pno",mobile);
                params.put("pass",pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
