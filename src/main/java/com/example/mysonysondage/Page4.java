package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Page4 extends AppCompatActivity implements View.OnClickListener {
    private EditText txSuggEco, txtSuggSoc;
    private Button btSuivant;
    private String email, idE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        this.txSuggEco = (EditText) findViewById(R.id.idTextSuggEco);
        this.txtSuggSoc = (EditText) findViewById(R.id.idTextSuggSoc);
        this.btSuivant = (Button) findViewById(R.id.idBtFin);
        this.btSuivant.setOnClickListener(this);
        if (this.getIntent().getStringExtra("email") != null) {
            this.email = this.getIntent().getStringExtra("email");
        }
        this.idE = this.getIntent().getStringExtra("idE");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idBtFin) {
            if (!this.txSuggEco.getText().equals("")) {
                Sony.getEnquete(this.idE).getCandidat(this.email).setSuggEco(this.txSuggEco.getText().toString());
            }
            if (!this.txtSuggSoc.getText().equals("")) {
                Sony.getEnquete(this.idE).getCandidat(this.email).setSuggSoc(this.txtSuggSoc.getText().toString());

            }
        }
        //ajouter la réponse du candidat dans l'enquetes

        Intent unIntent = new Intent(this, Fin.class);
        unIntent.putExtra("email", this.email);
        unIntent.putExtra("idE", this.idE);
        this.startActivity(unIntent);
        System.out.println("CanarySugg"+Sony.getEnquete(this.idE).getCandidat(this.email).getSuggSoc());
        System.out.println("CanarySugg2"+this.txSuggEco.toString());
    }
}
