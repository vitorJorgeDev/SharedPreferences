package com.androidcurse.sharepreferences.sharedpreferencesusingclass.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "shared.preferences";
    private final int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_NOME = "nome";
    private final String CHAVE_TELEFONE = "telefone";
    private final String CHAVE_IDADE = "idade";

    public Preferencias(Context contextoParametro){

        contexto = contextoParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE );
        editor = preferences.edit();

    }

    public void salvarUsuarioPreferencias(String nome, String telefone, String idade ){

        editor.putString(CHAVE_NOME, nome);
        editor.putString(CHAVE_TELEFONE, telefone);
        editor.putString(CHAVE_IDADE, idade);
        editor.commit();

    }

    public HashMap<String, String> getDadosusuario(){

        HashMap<String, String> dadosUsuario = new HashMap<>();

        dadosUsuario.put(CHAVE_NOME, preferences.getString(CHAVE_NOME, null ) );
        dadosUsuario.put(CHAVE_TELEFONE, preferences.getString(CHAVE_TELEFONE, null));
        dadosUsuario.put(CHAVE_IDADE, preferences.getString(CHAVE_IDADE, null));

        return dadosUsuario;

    }

    public void clearSharedPrefereces(){

        editor.clear();
        editor.commit();

    }

}
