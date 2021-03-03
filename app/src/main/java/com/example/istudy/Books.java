package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.istudy.books.p1eng;
import com.example.istudy.books.p3eng;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Books extends AppCompatActivity {

    @BindView(R.id.pay1)
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        ButterKnife.bind(this);

        payment.setOnClickListener(V->topayment());
    }

    public void button1(View view) {
        Intent intent = new Intent(Books.this, p1eng.class);
        startActivity(intent);
    }
    public void button2(View view) {
        Intent intent = new Intent(Books.this, p3eng.class);
        startActivity(intent);
    }

    public void topayment() {
        new RaveUiManager(this).setAmount(100)
                .setCurrency("RWF")
                .setfName("Benitha")
                .setlName("Uwase")
                .setEmail("benithauwase05@gmail.com")
                .setNarration("Book")
                .setPublicKey("FLWPUBK_TEST-e7170a6b8eeb8037d0eb1d5561c86a65-X")
                .setEncryptionKey("FLWSECK_TESTeb09f8eb8d17")
                .setTxRef(System.currentTimeMillis()+"ref")
                .setPhoneNumber("0780873772", true)
                .acceptAccountPayments(true)
                .acceptCardPayments(true)
                .acceptMpesaPayments(false)
                .acceptAchPayments(false)
                .acceptGHMobileMoneyPayments(false)
                .acceptUgMobileMoneyPayments(false)
                .acceptZmMobileMoneyPayments(false)
                .acceptRwfMobileMoneyPayments(true)
                .acceptSaBankPayments(false)
                .acceptUkPayments(false)
                .acceptBankTransferPayments(false)
                .acceptUssdPayments(false)
                .acceptBarterPayments(false)
                .acceptFrancMobileMoneyPayments(false)
                .allowSaveCardFeature(false)
                .onStagingEnv(false)
                .withTheme(R.style.MyCustomTheme)
                .initialize();

        Intent intent = new Intent(Books.this, PaymentActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*
         *  We advise you to do a further verification of transaction's details on your server to be
.         *  sure everything checks out before providing service or goods.
         */
        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            String message = data.getStringExtra("response");
            if (resultCode == RavePayActivity.RESULT_SUCCESS) {
                Toast.makeText(this, "SUCCESS " + message, Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RavePayActivity.RESULT_ERROR) {
                Toast.makeText(this, "ERROR " + message, Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
                Toast.makeText(this, "CANCELLED " + message, Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}