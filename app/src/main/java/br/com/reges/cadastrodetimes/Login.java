package br.com.reges.cadastrodetimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

/**
 * Created by Felipe on 31/03/2016.
 */
public class Login extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        final EditText user = (EditText) findViewById(R.id.TFUusario);
        final EditText password = (EditText) findViewById(R.id.TFSenha);
        Button btnLogar = (Button) findViewById(R.id.btnlogin);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = String.valueOf(user.getText());
                String senha = String.valueOf(password.getText());

                if(nome.equals("Felipe")) {

                    if(senha.equals("010203")) {

                        Intent irParaLista = new Intent(Login.this, ListaTimes.class);
                        startActivity(irParaLista);
                        finish();

                    } else {
                        dlgAlert();
                    }

                } else {
                    dlgAlert();
                }
            }
        });
    }

    private void dlgAlert() {

        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setTitle(R.string.app_name);
        dlgAlert.setMessage(R.string.invalid);
        dlgAlert.setNeutralButton("OK", null);
        dlgAlert.show();

    }
}