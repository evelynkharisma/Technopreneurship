package com.techno.technopreneurship;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RedeemRewardActivity extends Activity {
    EditText code;
    Button redeem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_reward);
        redeem = (Button) findViewById(R.id.btn_redeem);
        code = (EditText) findViewById(R.id.code);

        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code.getText().toString().equals("HospitalACode")) {
                    Toast.makeText(getApplicationContext(), "Redeem Success", 100).show();
                }
            }
        });
    }
}
