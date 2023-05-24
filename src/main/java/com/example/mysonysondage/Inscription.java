package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    public EditText txtNom, txtEmail, txtMdp;
    private Spinner spService;
    private Button btValider;
    private String idE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        this.txtNom = (EditText) findViewById(R.id.idEditTxtNom);
        this.txtEmail = (EditText) findViewById(R.id.idEditTxtEmail);
        this.txtMdp = (EditText) findViewById(R.id.idEditTextMdp);
        this.spService = (Spinner) findViewById(R.id.idSpiService);
        this.btValider = (Button) findViewById(R.id.idValider);
        this.idE = this.getIntent().getStringExtra("idE");


        this.btValider.setOnClickListener(this);
        //remplissage du spinner
        ArrayList<String> lesServices = new ArrayList<String>();
        lesServices.add("Marketing");
        lesServices.add("Label");
        lesServices.add("Logistique");
        lesServices.add("Agent");
        // On crée un adapter qui permet de structurer l'affichage dans el spinner
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lesServices);
        this.spService.setAdapter(unAdapter);
    }

    public void onClick(View v) {

        HashMap<String, Candidat> lesCandidats;
        if (v.getId() == R.id.idValider) {
            Toast.makeText(this, "Merci d'avoir accepté de répondre à l'enquête !", Toast.LENGTH_LONG).show();
            // instantiation d'un candidat
            Candidat unCandidat = new Candidat(
                    this.txtEmail.getText().toString(),
                    this.txtNom.getText().toString(),
                    this.spService.getSelectedItem().toString(),
                    this.txtMdp.getText().toString()
            );
            System.out.println("Canaryemail + " + unCandidat.getEmail());
            System.out.println("Canarynom + " + unCandidat.getNom());
            System.out.println("Canarymdp + " + unCandidat.getMdp());
            System.out.println("Canaryservice + " + unCandidat.getService());
            Sony.getEnquete(this.idE).ajouterCandidat(unCandidat);
            Intent unIntent = new Intent(this, Page1.class);
            unIntent.putExtra("email", this.txtEmail.getText().toString());
            unIntent.putExtra("idE", this.idE);
            this.startActivity(unIntent);
        }
    }
}


