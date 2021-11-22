package com.example.appliedfmysql;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import appliedfmysql.R;

public class ListRelevesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listreleves);


        //remplissage de la liste
        //Création d'une instance de la classe DAOReleve

        final ListView listViewReleves = findViewById(R.id.listViewReleves);



    }
}
