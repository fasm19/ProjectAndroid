package br.com.reges.cadastrodetimes;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Felipe on 17/03/2016.
 */
public class ListaTimes extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listatimes_main);

        ListView Lista = (ListView) findViewById(R.id.lista);
        registerForContextMenu(Lista);

        final String[] times = {"Barcelona", "Corinthians", "PSG", "Bayer de Munique"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, times);

        Lista.setAdapter(adapter);

        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaTimes.this, "Posição = " + position, Toast.LENGTH_SHORT).show();
            }
        });

        Lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaTimes.this, "Nome: = " + times[position], Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novotime_menu:
                Intent irParaFormTimes = new Intent(this, FormularioTimes.class);
                startActivity(irParaFormTimes);
                break;

            case R.id.sair_menu:
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setTitle("Cadastrar Time");
                dlgAlert.setMessage("Deseja sair?");
                dlgAlert.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialog, int wich){
                    ListaTimes.this.finish();
                }
            });

            dlgAlert.setNegativeButton("Não", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int wich){

                }

            });

            dlgAlert.create().show();

            break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem ligar = menu.add("Ligar");
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

             public boolean onMenuItemClick(MenuItem item) {
                 Intent irParaDiscagem = new Intent(Intent.ACTION_CALL);
                 String fone = "";
                 Uri numDiscagem = Uri.parse(fone);
                 irParaDiscagem.setData(numDiscagem);

                 if (ContextCompat.checkSelfPermission(ListaTimes.this, Manifest.permission.CALL_PHONE)
                         == PackageManager.PERMISSION_GRANTED) {
                     startActivity(irParaDiscagem);
                 }

                 return false;
             }
         }
        );

        menu.add("Apagar");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void  onButtonClick(View v){
        if(v.getId() == R.id.btnlogin){

            EditText a = (EditText)findViewById(R.id.TFUusario);
            String str = a.getText().toString();

            Intent i = new Intent(ListaTimes.this, Display.class);
            i.putExtra("Usuário", str);
            startActivity(i);
        }
    }
}

