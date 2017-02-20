package com.androidcurse.sharepreferences.sharedpreferencesusingclass.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidcurse.sharepreferences.sharedpreferencesusingclass.R;
import com.androidcurse.sharepreferences.sharedpreferencesusingclass.helper.Preferencias;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText nome, telefone, idade;
    private TextView nomeResultado, telefoneResultado, idadeResultado;
    private Button cadastrar, mostrar, limpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome                = (EditText) findViewById(R.id.edit_nomeUsuarioId);
        telefone            = (EditText) findViewById(R.id.edit_telefoneUsuarioId);
        idade               = (EditText) findViewById(R.id.edit_idadeUsuarioId);

        nomeResultado       = (TextView) findViewById(R.id.tvNomeResultadoUsuario);
        telefoneResultado   = (TextView) findViewById(R.id.tvTelefoneResultadoUsuario);
        idadeResultado      = (TextView) findViewById(R.id.tvIdadeResultadoUsuario);

        cadastrar           = (Button) findViewById(R.id.btn_salvarId);
        mostrar             = (Button) findViewById(R.id.btn_mostrarResultado);
        limpar              = (Button) findViewById(R.id.btn_clearSharedID);



        // Salvando dados do usuario
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Recuperando os dados digitados pelo usuario

                String nomeUsuario = nome.getText().toString();
                String telefoneUsuario = telefone.getText().toString();
                String idadeUsuario = idade.getText().toString();

                // Salando os dados usando a classe Preferencias

                Preferencias preferencias = new Preferencias(MainActivity.this);
                preferencias.salvarUsuarioPreferencias(nomeUsuario, telefoneUsuario, idadeUsuario);
                Toast.makeText(getApplicationContext(), "Dados Salvo com Sucesso", Toast.LENGTH_SHORT).show();

                nome.setText("");
                telefone.setText("");
                idade.setText("");


            }
        });

        // Recuperando dados do usuario

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Preferencias preferencias = new Preferencias(MainActivity.this);
                HashMap<String, String> usuario = preferencias.getDadosusuario();

                nomeResultado.setText(usuario.get("nome"));
                idadeResultado.setText(usuario.get("idade"));
                telefoneResultado.setText(usuario.get("telefone"));

            }
        });

        // Limpando sharedPreferences

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Preferencias preferencias = new Preferencias(MainActivity.this);
                preferencias.clearSharedPrefereces();

            }
        });




    }
}
