package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityJP extends AppCompatActivity {

    private static final String TAG = "MyAppJP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jp);

        Log.i(TAG, "Это данные веса и количества шагов.");

        Button btnSaveJP = findViewById(R.id.btnSaveJP);
        btnSaveJP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double netto = 0.0;
                Integer KSh = 0;
                List list = new ArrayList<>();

                EditText editNetto = findViewById(R.id.editNetto);
                String txtNetto = editNetto.getText().toString();

                EditText editKSh = findViewById(R.id.editKSh);
                String txtKSh = editKSh.getText().toString();

                try {
                    netto = Double.parseDouble(txtNetto);
                }catch (Exception e) {
                    Log.e(TAG, "Получено исключение данных веса и количества шагов", e);
                    Toast toast = Toast.makeText(ActivityJP.this, R.string.error,Toast.LENGTH_LONG);
                    toast.show();
                }
                try {
                    KSh = Integer.parseInt(txtKSh);
                }catch (Exception e) {
                    Log.e(TAG, "Получено исключение данных веса и количества шагов", e);
                    Toast toast = Toast.makeText(ActivityJP.this, R.string.error,Toast.LENGTH_LONG);
                    toast.show();
                }

                if (netto > 0) {
                    if (KSh > 0) {

                        list.add(netto);
                        list.add(KSh);

                        SaveForJP saveForJP = new SaveForJP(list);

                        Toast toast = Toast.makeText(ActivityJP.this, saveForJP.toString(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
    }
}
