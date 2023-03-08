package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        komentarText = findViewById(R.id.komentarText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "siklus onstar", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "siklus onstop", Toast.LENGTH_SHORT).show();
        //save data
        saveDataKomentar(komentarText.getText().toString());
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "siklus onpause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "siklus onresume", Toast.LENGTH_SHORT).show();
        //ambil data yang tersimpan
        String datakomentar = ambilDataKomentar();
        super.onResume();
    }
    private void saveDataKomentar(String value){
        SharedPreferences.Editor editor= this.getSharedPreferences("komentar", Context.MODE_PRIVATE).edit();
        editor.putString("keyKomentar", value);
        editor.commit();
    }
    private String ambilDataKomentar(){
        String result = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).getString("komentar", null);
        return result;

    }

}