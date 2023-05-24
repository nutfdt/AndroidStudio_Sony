package com.example.mysonysondage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Resultatall extends AppCompatActivity implements View.OnClickListener {
    private ListView liste;
    private String idE, email;
    private Button btRetour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultatall);
        this.liste = (ListView) findViewById(R.id.idListe);
        this.btRetour=(Button)findViewById(R.id.idBtRetour) ;
        this.email = this.getIntent().getStringExtra("email");
        this.idE = this.getIntent().getStringExtra("idE");
        this.btRetour.setOnClickListener(this);

        //afficher les candidats participants dans la listeView
        float moyenne = Sony.getEnquete(this.idE).moyenne(this.email);
        ArrayList<String> lesParticipants = new ArrayList<>();
        for (Candidat unCandidat : Sony.getEnquete(this.idE).getLesCandidats().values()){
            lesParticipants.add(unCandidat.getNom().toUpperCase() + " Service : " + unCandidat.getService() +
                    "   Résultat : " + unCandidat.moyenne() +"/20" +
                    "\n" + "Suggestion : "+unCandidat.getSuggEco()+" - " +unCandidat.getSuggSoc());
        }
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lesParticipants);
        this.liste.setAdapter(unAdapter);

    }

    @Override
    public void onClick(View view) {
        if ( view.getId() == R.id.idBtRetour){
            Intent unIntent = new Intent(this, Fin.class);
            unIntent.putExtra("email", this.email);
            unIntent.putExtra("idE", this.idE);
            this.startActivity(unIntent);
    }
}
}