package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {

    EditText ednama, edemail, edpass, edrepass;
    Button btnregis;
    String nama, email, password, repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btnregis = findViewById(R.id.btnRegister);
        ednama = findViewById(R.id.edNama);
        edemail = findViewById(R.id.edEmail);
        edpass = findViewById(R.id.edpassword);
        edrepass = findViewById(R.id.edRepassword);

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = ednama.getText().toString();
                email = edemail.getText().toString();
                password = edpass.getText().toString();
                repass = edrepass.getText().toString();

                if (ednama.getText().toString().length()==0){
                    ednama.setError("Nama Tidak Boleh Kosong!");
                }
                if (edemail.getText().toString().length()==0){
                    edemail.setError("Email Tidak Boleh Kosong!");
                }
                if (edpass.getText().toString().length()==0){
                    edpass.setError("Password Tidak Boleh Kosong!");
                }
                if (edrepass.getText().toString().length()==0){
                    edrepass.setError("RePassword Tidak Boleh Kosong!");
                }
                else {
                    if (edpass.getText().toString().equals(edrepass.getText().toString())) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "pendaftaran sukses", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());

                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);
                        i.putExtras(b);
                        startActivity(i);
                    } else {
                        Snackbar.make(view, "Password yang dimasukkan Berbeda",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
