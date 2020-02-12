package com.example.healthmonitoringsystem;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyAppMAin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Это данные для персонализации.");

        Button btnSaveMA = findViewById(R.id.btnSaveMA);
        btnSaveMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameMA;
                Integer oldMA = 0;

                EditText txtEditName = findViewById(R.id.editName);
                EditText txtEditOld = findViewById(R.id.editOld);

                nameMA = txtEditName.getText().toString();
                String sTxtEditOld = txtEditOld.getText().toString();

                try {
                    oldMA = Integer.parseInt(sTxtEditOld);
                }
                catch (NumberFormatException e1){
                    Log.e(TAG, "Получено исключение возраста", e1);
                    Toast toast = Toast.makeText(MainActivity.this, R.string.error,Toast.LENGTH_LONG);
                    toast.show();
                }

                Map<String, Integer> lao = new TreeMap<>();

                if (oldMA > 0) {
                    lao.put(nameMA, oldMA);

                    SaveForMA lao2 = new SaveForMA(lao);

                    Toast toast2 = Toast.makeText(MainActivity.this, lao2.toString(), Toast.LENGTH_LONG);
                    toast2.show();
                }else {

                    Toast toast3 = Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_LONG);
                    toast3.show();
                }
            }
        });

        Button btnZD = findViewById(R.id.btnZD);
        btnZD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActivityPD.class);
                startActivity(intent);
            }
        });

        Button btnZJP = findViewById(R.id.btnZJP);
        btnZJP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActivityJP.class);
                startActivity(intent);
            }
        });


    }
}
