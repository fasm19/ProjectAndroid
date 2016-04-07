package br.com.reges.cadastrodetimes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Felipe on 31/03/2016.
 */
public class Display {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String usuario = getIntent().getStringExtra("Usuário");

        TextView tv = (TextView) findViewById(R.id.TVusuario);
    }

    public void  onButtonClick(View v){
        if(v.getId() == R.id.btnIrFormulario){

            Intent i = new Intent(Display.this, FormularioTimes.class);
            startActivity(i);
        }


    }
