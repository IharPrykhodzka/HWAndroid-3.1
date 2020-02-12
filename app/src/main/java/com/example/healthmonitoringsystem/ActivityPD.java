package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ActivityPD extends AppCompatActivity {

    private static final String TAG = "MyAppPD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pd);

        Log.i(TAG, "Это данные давления и пульса.");

        Button btnPD = findViewById(R.id.btnSavePD);
        btnPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer upD = 0;
                Integer downD = 0;
                Integer pulsTrue = 0;
                List list = new ArrayList();


                EditText editVD = findViewById(R.id.editVD);
                String txtVD = editVD.getText().toString();

                EditText editND = findViewById(R.id.editND);
                String txtND = editND.getText().toString();

                EditText puls = findViewById(R.id.puls);
                String txtPuls = puls.getText().toString();

                CheckBox checkBoxT = findViewById(R.id.checkBoxT);
                String thrd = checkBoxT.toString();

                try {
                    upD = Integer.parseInt(txtVD);

                }catch (Exception e2) {
                    Log.e(TAG, "Получено исключение верхнего давления", e2);
                    Toast toast = Toast.makeText(ActivityPD.this, R.string.error,Toast.LENGTH_LONG);
                    toast.show();
                }

                try {
                    downD = Integer.parseInt(txtND);
                }catch (NumberFormatException e3) {
                    Log.e(TAG, "Получено исключение нижнего давления", e3);
                    Toast toast = Toast.makeText(ActivityPD.this, R.string.error,Toast.LENGTH_LONG);
                    toast.show();
                }

                try {
                    pulsTrue = Integer.parseInt(txtPuls);
                }catch (NumberFormatException e4) {
                    Log.e(TAG, "Получено исключение пульса", e4);
                    Toast toast = Toast.makeText(ActivityPD.this, R.string.error,Toast.LENGTH_LONG);
                    toast.show();
                }

                if (upD > 0) {
                    if (downD > 0) {
                        if (pulsTrue > 0) {
                            list.add(upD);
                            list.add(downD);
                            list.add(pulsTrue);
                            list.add(thrd);

                            SaveForPD saveForPD = new SaveForPD(list);

                            Toast toast = Toast.makeText(ActivityPD.this, saveForPD.toString(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }
            }
        });
    }
}
