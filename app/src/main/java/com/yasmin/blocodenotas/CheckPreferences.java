package com.yasmin.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class CheckPreferences {

    private Context context;
    private SharedPreferences preferences;
    ////responsavel por salvar anotacao
    private SharedPreferences.Editor editor;

    private final  String NOME_ARQUIVO = "anotation.preferences";
    private final String CHAVE_NOME = "nome";


    public CheckPreferences(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();
    }

    public void checkAnotation(String anotation){
        editor.putString(CHAVE_NOME,anotation);
        editor.commit();
    }

    public String recupeAnotation(){

        return preferences.getString(CHAVE_NOME,"");
    }

}
