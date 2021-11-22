package com.example.appliedfmysql;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.appliedfmysql.Modele.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import appliedfmysql.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListClientsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listclients);

        //on définit une collection de caractéristiques d un client
        ArrayList<Client> lesClients = new ArrayList<Client>();
        //on définit un objet ListView
        ListView listViewClients;
        //on associe l'objet au widget
        listViewClients = findViewById(R.id.listViewClients);

        //creation de la requete http sur le serveur local, cela necessite
        OkHttpClient httpclient = new OkHttpClient();

        //prépare la requête
        Request requestClients = new Request.Builder().url("http://192.168.1.21:80/apiEDFMySQL/getAllClientsJSON.php").build();
        //exécution de cette requête
        httpclient.newCall(requestClients).enqueue(new Callback() {
            @Override
            //si la requête échoue affichage d'un message d'erreur dans les log
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.i("erreur1", "erreur requete getAllClientsJSON.php");
            }

            @Override
            //si la requête réussie
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();
                ListClientsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // on crée un objet JSON à partir de notre réponse.
                            JSONObject jsonObjectlesclients = new JSONObject(myResponse);
                            //on transforme cet objet JSON en array d'objet client sous forme JSON
                            JSONArray jsonArray = jsonObjectlesclients.optJSONArray("clients");
                            //on parcours cette collection d'objet clients pour ajouter chaque client dans notre liste d'objet client


                            //on efface le contenu de la liste
                            lesClients.clear();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer numcli = Integer.valueOf(jsonObject.getString("numcli"));
                                String nomPrenom = jsonObject.getString("nomprenomcli");
                                String email = jsonObject.getString("email");
                                String adresse = jsonObject.getString("adressecli");
                                String tel = jsonObject.getString("telcli");
                                Log.i("clients", numcli + " " + nomPrenom + "  " + email + " " + adresse + " " + tel); //message qui apparait dans la console pour vérifier
                                Client c = new Client(nomPrenom, email, adresse, tel);
                                //on ajoute le client à la collection lesClients
                                lesClients.add(c);
                            }
                            //on affecte cette liste d'objet clients dans la listeview pour l'afficher
                            ArrayAdapter<Client> dataAdapter = new ArrayAdapter<Client>(ListClientsActivity.this, android.R.layout.simple_list_item_1, lesClients);
                            listViewClients.setAdapter(dataAdapter);

                        } catch (final JSONException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i("erreur2", "erreur ligne 89");
                                }
                            });
                        }
                    }

                });
            }

            ;
        });

        //on sélectionne un client de la liste et l'on passe son id à l'activity AfficheUnClient

        listViewClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "id selectionné : " + String.valueOf(id), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListClientsActivity.this, AfficheUnClientActivity.class);
                intent.putExtra("IDCLI", id);
                startActivity(intent);
            }
        });
    }

}

