package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rgSocial;
    private Button btSuivant;
    private String email, idE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.rgSocial = (RadioGroup) findViewById(R.id.idSocial);
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
            int score = 0;
            switch (this.rgSocial.getCheckedRadioButtonId()) {
                case R.id.idSocial1:
                    score = 20;
                    break;
                case R.id.idSocial2:
                    score = 16;
                    break;
                case R.id.idSocial3:
                    score = 12;
                    break;
                case R.id.idSocial4:
                    score = 8;
                    break;
                case R.id.idSocial5:
                    score = 4;
                    break;
            }
            //ajouter la réponse du candidat dans l'enquete
            Sony.getEnquete(this.idE).ajouterReponse("Social", score, this.email);
            Intent unIntent = new Intent(this, Page3.class);
            unIntent.putExtra("email", this.email);
            unIntent.putExtra("idE", this.idE);
            this.startActivity(unIntent);
        }
    }
}