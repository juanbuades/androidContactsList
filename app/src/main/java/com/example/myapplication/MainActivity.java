package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    ArrayList<Enemy> enemies;
    EditText name;
    EditText age;
    EditText description;
    Button addEnemyButton;
    Enemy enemy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enemies = new ArrayList<>();

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        description = findViewById(R.id.description);
        addEnemyButton = findViewById(R.id.addEnemyButton);

        list = findViewById(R.id.list);
        ListAdapter adapter = new ArrayAdapter<Enemy>(this, android.R.layout.simple_list_item_1, enemies);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }

    public void add (View view){
        String newName = name.getText().toString();
        String newAge = age.getText().toString();
        int newAgeInt = Integer.parseInt(newAge);
        String newDescription = description.getText().toString();
        Enemy newEnemy = new Enemy(newName, newAgeInt, newDescription);
        if (newName == null) {
            Toast.makeText(getApplicationContext(),"Indique el nombre del nuevo enemigo", Toast.LENGTH_LONG).show();
        }
        else if (newAgeInt > 150) {
            Toast.makeText(getApplicationContext(),"Enemigo mayor de 150 años" , Toast.LENGTH_LONG).show();
        }
        else if (newAgeInt < 0){
            Toast.makeText(getApplicationContext(),"Enemigo no ha nacido todavia" , Toast.LENGTH_LONG).show();
        }
        else {
            enemies.add(newEnemy);
            ArrayAdapter adapter = (ArrayAdapter) list.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Enemy selectedEnemy = enemies.get(position);
        Intent intent = new Intent (MainActivity.this, EnemyInformation.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("enemy", selectedEnemy);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}