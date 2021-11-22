package com.example.appliedfmysql;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.appliedfmysql.Modele.Client;

import appliedfmysql.R;

public class AfficheUnClientActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficheunclient);

        //récupère id du client passé entre les deux interfaces
        Intent intent = getIntent();
        long idcli = intent.getLongExtra("IDCLI", 0);
        //on va dans la bdd chercher toutes les infos sur ce client
        //ouvrir la bdd



        //mettre les données récupérées de la requête SQL dans les zones textes de la vue
        TextView NomPrenomLu = findViewById(R.id.textViewNomPrenomLu);
        TextView AdresseLu = findViewById(R.id.textViewAdresseLu);
        TextView EmailLu = findViewById(R.id.textViewEmailLu);
        TextView TelLu = findViewById(R.id.textViewTelLu);
       // NomPrenomLu.setText(clientlu.getNomPrenom());
      //  AdresseLu.setText(clientlu.getAdresse());
      //  EmailLu.setText(clientlu.getEmail());
      //  TelLu.setText(clientlu.getTel());
        //fermer la BDD

    }

}