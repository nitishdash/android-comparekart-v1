package com.dashlabs.nitishdash.comparekartv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LandingActivity extends AppCompatActivity implements Button.OnClickListener {


    private Button checkPriceButton;
    private Button findProductButton;
    private EditText pidEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //INITIALISERS

        checkPriceButton = (Button) findViewById(R.id.button);
        findProductButton = (Button) findViewById(R.id.button2);
        pidEditText = (EditText) findViewById(R.id.editText);

        //SET ALL THE CLICK LISTENERS HERE
        checkPriceButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v==checkPriceButton){

            Intent intent = new Intent(this, PriceTrackingActivity.class);
            String pid_from_intent = pidEditText.getText().toString();
            intent.putExtra("pid_from_intent", pid_from_intent);
            startActivity(intent);
        }
        else if(v==findProductButton) {

        }

    }
}
