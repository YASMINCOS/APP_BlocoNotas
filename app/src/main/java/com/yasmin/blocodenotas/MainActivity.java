package com.yasmin.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private CheckPreferences preferences;
    private EditText editAnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Anotações");

        FloatingActionButton fbCheck = findViewById(R.id.fb_check);
        editAnotation = findViewById(R.id.editAnotacao);

        preferences = new CheckPreferences(getApplicationContext());

        fbCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String textRecuperado = editAnotation.getText().toString();

                if (textRecuperado.equals("")){
                    Toast.makeText(getApplicationContext(),"Insira uma anotação!",Toast.LENGTH_LONG).show();
                }else {
                    preferences.checkAnotation(textRecuperado);
                    Toast.makeText(getApplicationContext(),"Anotação inserida com sucesso!",Toast.LENGTH_LONG).show();
                }
            }
        });

        String anotation = preferences.recupeAnotation();


        if( !anotation.equals("")){
            editAnotation.setText(anotation);
        }
    }
}