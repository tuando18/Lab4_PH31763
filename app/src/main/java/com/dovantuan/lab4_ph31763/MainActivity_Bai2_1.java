package com.dovantuan.lab4_ph31763;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_Bai2_1 extends AppCompatActivity {

    ActivityResultLauncher<Intent> getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 1) {
                        Intent intent = result.getData();
                        TextView txtPrice = findViewById(R.id.txt_price);
                        if (intent != null) {
                            Bundle bundle = intent.getExtras();
                            String priceData = bundle.getString("priceData");
                            txtPrice.setText(priceData);
                        }
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai21);

        Button btn = findViewById(R.id.btn_gui);
        EditText editName = findViewById(R.id.input);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Bai2_1.this, MainActivity_Bai2_2.class);
                intent.putExtra("name", editName.getText().toString());
                getData.launch(intent);
            }
        });
    }
}