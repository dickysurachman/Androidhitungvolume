package itts.dicky.surachman.dicoding1c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText lebar1;
    private EditText  panjang1;
    private EditText tinggi1;
    private Button butt;
    private TextView hasil1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tinggi1=findViewById(R.id.tinggi);
        panjang1 = findViewById(R.id.panjang);
        lebar1=findViewById(R.id.lebar);
        hasil1 =findViewById(R.id.hasil);
        butt=findViewById(R.id.button);
        butt.setOnClickListener(this);
        panjang1.requestFocus();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                Boolean Iserr=true;
                String  lebar1a= lebar1.getText().toString().trim();// .toString().trim();//  lebar1.toString().trim();
                String  panjang1a= panjang1.getText().toString().trim();
                String tinggi1a= tinggi1.getText().toString().trim();
                if(TextUtils.isEmpty(lebar1a))
                {
                    Iserr=false;
                    lebar1.setError("Tidak boleh kosong");
                }
                if(TextUtils.isEmpty(panjang1a)){
                Iserr=false;
                panjang1.setError("Tidak boleh kosong");
                }
                if(TextUtils.isEmpty(tinggi1a)){
                Iserr=false;
                tinggi1.setError("Tidak boleh kosong");
                }
                if(Iserr=true){
                    //hasil1.setText(lebar1a);
                    try {

                        Double hasil1a=Double.valueOf(lebar1a)*Double.valueOf(panjang1a)*Double.valueOf(tinggi1a);
                        hasil1.setText(String.valueOf(hasil1a));
                    } catch (NumberFormatException e){
                        Context context = getApplicationContext();
                        CharSequence text = e.getMessage();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        //Toast.makeText(e.getCause());
                    }
                }
                break;
        }
    }
}