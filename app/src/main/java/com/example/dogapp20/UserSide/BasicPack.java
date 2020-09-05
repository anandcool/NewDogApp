package com.example.dogapp20.UserSide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dogapp20.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class BasicPack extends AppCompatActivity  implements PaymentResultListener {

    Button btn_nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicpacks);
        btn_nxt = findViewById(R.id.next);
        btn_nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });
    }

    public void startPayment () {
        Checkout checkout = new Checkout();  /**   * Set your logo here   */
        checkout.setKeyID("rzp_test_k3OFACxp2Yg4Br");	/**   * Instantiate Checkout   */
        final Activity activity = this;  /**   * Pass your payment options to the Razorpay Checkout as a JSONObject   */
        try {
            JSONObject options = new JSONObject();      /**      * Merchant Name      * eg: ACME Corp || HasGeek etc.      */
            options.put("name", "Merchant Name");      /**      * Description can be anything      * eg: Reference No. #123123 - This order number is passed by you for your internal reference. This is not the `razorpay_order_id`.      *     Invoice Payment      *     etc.      */
            options.put("description", "Reference No. #123456");
            options.put("currency", "INR");      /**      * Amount is always passed in currency subunits      * Eg: "500" = INR 5.00      */
            options.put("amount", "500");
            checkout.open(activity, options);
        }
        catch(Exception e){
            Log.e("something", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment is done", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(BasicPack.this,ChatActivity.class);
        startActivity(in);
    }

    @Override
    public void onPaymentError(int i, String s) {

    }
}
