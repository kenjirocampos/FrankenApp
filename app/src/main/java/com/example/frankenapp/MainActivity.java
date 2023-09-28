package com.example.frankenapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Spinner spinnerColores;
private RadioButton rb1,rb2;
private String resultado;
private CheckBox[] checkBoxes = new CheckBox[9];
private Button button;
private ToggleButton toggleButton;
private AlertDialog.Builder mensaje;
private EditText text1;
private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerColores = (Spinner) findViewById(R.id.spinnerColores);
        button = (Button) findViewById(R.id.button);
        for (int i = 0; i < 9; i++) {
            int checkBoxId = getResources().getIdentifier("cbox" + (i + 1), "id", getPackageName());
            checkBoxes[i] = findViewById(checkBoxId);
        }
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        toggleButton = (ToggleButton) findViewById(R.id.tb1);
        text1 = (EditText) findViewById(R.id.text1);
        mensaje = new AlertDialog.Builder(this);
        resultado = "";
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
    }

    public void cambiarActivity(View v){
        Intent cambiar = new Intent(this,RatingActivity.class);
        startActivity(cambiar);
    }
    public void habilitarContenido(View v){
        if(toggleButton.isChecked()) {
            text1.setEnabled(true);
            spinnerColores.setEnabled(true);
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            button.setEnabled(true);
            for (CheckBox checkBox : checkBoxes) {
                checkBox.setEnabled(true);
            }
        }else{
            text1.setEnabled(false);
            spinnerColores.setEnabled(false);
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            button.setEnabled(false);
            for (CheckBox checkBox : checkBoxes) {
                checkBox.setEnabled(false);
            }
        }
    }
    public void capturarData(View v){
        resultado = text1.getText().toString();
        resultado = resultado + "\nColor: "+spinnerColores.getSelectedItem().toString();
        if(rb1.isChecked()){
           resultado = resultado+"\nGenero: "+rb1.getText().toString();
        }else if(rb2.isChecked()){
            resultado = resultado+"\nGenero: "+rb2.getText().toString();
        }
        resultado = resultado + "\nCategorias: ";
        for (CheckBox checkBox : checkBoxes) {
            if(checkBox.isChecked()){
                resultado = resultado + checkBox.getText().toString()+" ";
            }
        }
        progressBar1.setProgress(100);
        mensaje.setTitle("Resultado capturado");
        mensaje.setMessage(resultado);
        mensaje.setCancelable(true);
        mensaje.show();
    }
}