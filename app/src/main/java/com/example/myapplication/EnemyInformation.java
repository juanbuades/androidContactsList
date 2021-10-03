package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EnemyInformation extends AppCompatActivity {

    TextView nameInformation;
    TextView ageInformation;
    TextView descriptionInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemy_information);
        nameInformation = findViewById(R.id.nameInformation);
        ageInformation = findViewById(R.id.ageInformation);
        descriptionInformation = findViewById(R.id.descriptionInformation);

        Bundle information=getIntent().getExtras();
        Enemy enemy = null;

        if(information != null) {
            enemy = (Enemy) information.getSerializable("enemy");
            nameInformation.setText(enemy.getName().toString());
            ageInformation.setText(enemy.getAge().toString());
            descriptionInformation.setText(enemy.getDescription().toString());
        }

    }

}