package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class Page3 extends AppCompatActivity implements View.OnClickListener {
    private RatingBar rbBien, rbSecu;
    private int nbEtoileSecu = 0, nbEtoileBien = 0;
    private String email, idE;
    private Button btSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        this.rbBien = (RatingBar) findViewById(R.id.idRatingB2);
        this.rbSecu = (RatingBar) findViewById(R.id.idRatingB1);
        this.btSuivant = (Button) findViewById(R.id.idBtSuivant);
        this.btSuivant.setOnClickListener(this);
        if (this.getIntent().getStringExtra("email") != null) {
            this.email = this.getIntent().getStringExtra("email");
        }
        this.idE = this.getIntent().getStringExtra("idE");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idBtSuivant) {
            if (this.rbSecu.getNumStars() != 0) {
                this.nbEtoileSecu = this.rbSecu.getNumStars();
                Sony.getEnquete(this.idE).getCandidat(this.email).setRbSecu(nbEtoileSecu);
                Sony.getEnquete(this.idE).getCandidat(this.email).ajouterReponse("Etoile1",this.nbEtoileSecu*2 );
            }
            if (this.rbBien.getNumStars() != 0) {
                this.nbEtoileBien = this.rbBien.getNumStars();
                Sony.getEnquete(this.idE).getCandidat(this.email).setRbSecu(nbEtoileBien);
                Sony.getEnquete(this.idE).getCandidat(this.email).ajouterReponse("Etoile2",this.nbEtoileBien*2 );

            }

        }
        //ajouter la réponse du candidat dans l'enquetes
        Intent unIntent = new Intent(this, Page4.class);
        unIntent.putExtra("email", this.email);
        unIntent.putExtra("idE", this.idE);
        this.startActivity(unIntent);
    }
}