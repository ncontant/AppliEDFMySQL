package com.example.appliedfmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import appliedfmysql.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //on associe à un objet java de type Button, un widget repéré physiquement par son id
        Button btnNewReleve = findViewById(R.id.btnNvReleve);
        Button btnListeClients = findViewById(R.id.btnListeClient);
        Button btnListeReleves = findViewById(R.id.btnListeReleves);
        Button btnNewClient = findViewById(R.id.btnNvClient);
        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnNvReleve:
                        Intent intent1 = new Intent(MainActivity.this, NewReleveActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.btnListeClient:
                        Intent intent2 = new Intent(MainActivity.this, ListClientsActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.btnNvClient:
                        Intent intent3 = new Intent(MainActivity.this, NewClientActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.btnListeReleves:
                        Intent intent4 = new Intent(MainActivity.this, ListRelevesActivity.class);
                        startActivity(intent4);
                        break;
                }
            }
        };
        //on affecte au bouton l'écouteur
        btnNewReleve.setOnClickListener(ecouteur);
        btnListeClients.setOnClickListener(ecouteur);
        btnListeReleves.setOnClickListener(ecouteur);
        btnNewClient.setOnClickListener(ecouteur);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_newClient:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre Saisir nouveau client !", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MainActivity.this, NewClientActivity.class);
                startActivity(intent1);
                return true;
            case R.id.menu_newReleve:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre nouveau relevé !", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this, NewReleveActivity.class);
                startActivity(intent2);
                return true;
            case R.id.menu_listeClients:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre liste déroulante des clients !", Toast.LENGTH_LONG).show();

                return true;
            case R.id.menu_listeReleves:
                Toast.makeText(getApplicationContext(), "ouverture fenêtre liste des relevés !", Toast.LENGTH_LONG).show();

                return true;

        }
        return false;
    }

}