package br.com.reges.cadastrodetimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Felipe on 17/03/2016.
 */
public class FormularioTimes extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_layout);

        final EditText txtEquipe = (EditText) findViewById(R.id.RespostaEquipe);
        final EditText txtSite = (EditText) findViewById(R.id.DiretorioSite);
        final EditText CadastroPara = (EditText) findViewById(R.id.idCadastroPara);

        Button btnSalvar = (Button) findViewById(R.id.form_btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String equipe = String.valueOf(txtEquipe.getText());
                String site = String.valueOf(txtSite.getText());
                String equipeSite = equipe + site;

                CadastroPara.setText(equipeSite);

            }

        });

    }
}