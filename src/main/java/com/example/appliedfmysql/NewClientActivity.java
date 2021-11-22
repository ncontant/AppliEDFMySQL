package com.example.appliedfmysql;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appliedfmysql.Modele.Client;

import appliedfmysql.R;
public class NewClientActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newclient);

        //programmation des boutons enregistrer et quitter
        Button btnEnregistrerClient = findViewById(R.id.btnEnregistrerClient);
        Button btnQuitterNewClient = findViewById(R.id.btnQuitterNewClient);



        //récupération des données saisies
        final EditText nomprenom = findViewById(R.id.editTextPersonName);

        final EditText email = findViewById(R.id.editTextEmail);

        final EditText adresse = findViewById(R.id.editTextAdresse);

        final EditText tel = findViewById(R.id.editTextTel);

        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnEnregistrerClient:
                        Toast.makeText(getApplicationContext(), "enregistrement du nouveau client !", Toast.LENGTH_LONG).show();
                        Client unclient = new Client(nomprenom.getText().toString(), email.getText().toString(), adresse.getText().toString(), tel.getText().toString());

                        //le curseur pour afficher le nombre de clients dans la base



                        finish();
                        break;
                    case R.id.btnQuitterNewClient:
                        finish();
                        break;

                }
            }
        };
        //on affecte au bouton l'écouteur
        btnEnregistrerClient.setOnClickListener(ecouteur);
        btnQuitterNewClient.setOnClickListener(ecouteur);

    }
}
