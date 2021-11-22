package com.example.appliedfmysql;

import android.app.Activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import android.widget.Toast;


import com.example.appliedfmysql.Modele.Releve;
import appliedfmysql.R;

public class NewReleveActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreleve);

        //remplissage de la liste déroulante
        //Création d'une instance de la classe DAOClient

        //objet java spinner relié au widget spinner
        final Spinner listDeroulanteClients = findViewById(R.id.spinnerListeClients);
        //On ouvre la table

        //on récupère tous les clients

        //on définie un modèle à notre liste déroulante avec son comportement

        //on affecte ce modèle à notre liste déroulante
        //listDeroulanteClients.setAdapter(adapter);
        //on ferme la table


        //récupération des données saisies
        //on déclare des objets java pour chaque widjet et obligatoirement en constante car on les passera ensuite à une autre interface
        final EditText heurepleine = findViewById(R.id.editTextHP);
        final EditText heurecreuse = findViewById(R.id.editTextHC);
        final String[] raison = {""};
        //numcli est un tableau d'entiers à une valeur
        final Integer[] numCli = new Integer[1];

        //programmation des boutons radios
        RadioGroup radioGroupRaison = findViewById(R.id.radioGroupRaison);
        radioGroupRaison.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroupRaison, int i) {
                switch (i) {
                    case R.id.radioButtonNormal:
                        raison[0] = "Normal";
                        Toast.makeText(getApplicationContext(), raison[0], Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButtonDemenagement:
                        raison[0] = "Emménagement";
                        Toast.makeText(getApplicationContext(), raison[0], Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButtonChangement:
                        raison[0] = "Changement";
                        Toast.makeText(getApplicationContext(), raison[0], Toast.LENGTH_LONG).show();
                        break;
                }
            }

        });


        //pour la liste déroulante on récupère un élément de la liste

        listDeroulanteClients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // numCli[0] = Math.toIntExact(listDeroulanteClients.getSelectedItemId());
                      numCli[0]= (listDeroulanteClients.getId());
                    //ou numCli[0]=  Math.toIntExact(listDeroulanteClients.getSelectedItemId());
                Toast.makeText(NewReleveActivity.this, "Vous avez choisie : " + "\nle client numéro : " + numCli[0], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //cas où rien n'est sélectionné

            }
        });





        //programmation des boutons enregistrer et quitter
        Button btnEnregistrerReleve = findViewById(R.id.btnEnregistrerReleve);
        Button btnQuitterNewReleve = findViewById(R.id.btnQuitterNewReleve);
        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnEnregistrerReleve:
                        Toast.makeText(getApplicationContext(), "enregistrement du nouveau relevé !", Toast.LENGTH_LONG).show();
                        Releve unreleve = new Releve(heurepleine.getText().toString(), heurecreuse.getText().toString(), raison[0], numCli[0]);
                        finish();
                        break;
                    case R.id.btnQuitterNewReleve:
                        finish();
                        break;

                }
            }
        };
        //on affecte au bouton l'écouteur
        btnEnregistrerReleve.setOnClickListener(ecouteur);
        btnQuitterNewReleve.setOnClickListener(ecouteur);

    }
}


