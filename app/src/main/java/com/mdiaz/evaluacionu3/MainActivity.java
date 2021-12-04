package com.mdiaz.evaluacionu3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    DatabaseReference mDatabase;

    private TextView textViewNombreSensor,textViewValorSensor,
                        textViewNombreSensor2,textViewValorSensor2,
                        textViewNombreSensor3,textViewValorSensor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SENSOR1
        textViewNombreSensor = (TextView) findViewById(R.id.textViewNombreSensor);
        textViewValorSensor = (TextView) findViewById(R.id.textViewValorSensor);

        //SENSOR2
        textViewNombreSensor2 = (TextView) findViewById(R.id.textViewNombreSensor2);
        textViewValorSensor2 = (TextView) findViewById(R.id.textViewValorSensor2);

        //SENSOR3
        textViewNombreSensor3 = (TextView) findViewById(R.id.textViewNombreSensor3);
        textViewValorSensor3 = (TextView) findViewById(R.id.textViewValorSensor3);


        // Write a message to the database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //MOSTRAR DATOS SENSOR1
        mDatabase.child("Sensores").child("Nombre de Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String NombreDeSensor = snapshot.getValue(String.class);
                textViewNombreSensor.setText(NombreDeSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores").child("Valor del sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ValorDelSensor = snapshot.getValue(String.class);
                textViewValorSensor.setText(ValorDelSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        //MOSTRAR DATOS SENSOR2
        mDatabase.child("Sensores2").child("Nombre de Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String NombreDeSensor = snapshot.getValue(String.class);
                textViewNombreSensor2.setText(NombreDeSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores2").child("Valor del sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ValorDelSensor = snapshot.getValue(String.class);
                textViewValorSensor2.setText(ValorDelSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        //MOSTRAR DATOS SENSOR3
        mDatabase.child("Sensores3").child("Nombre de Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String NombreDeSensor = snapshot.getValue(String.class);
                textViewNombreSensor3.setText(NombreDeSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores3").child("Valor del sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ValorDelSensor = snapshot.getValue(String.class);
                textViewValorSensor3.setText(ValorDelSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }

    public void mostrarDetalles(View view){
        Intent intent = new Intent(this,MostrarDetalles.class);
        startActivity(intent);
    }

    public void mostrarDetalles2(View view){
        Intent intent2 = new Intent(this,MostrarDetalles2.class);
        startActivity(intent2);
    }

    public void mostrarDetalles3(View view){
        Intent intent3 = new Intent(this,MostrarDetalles3.class);
        startActivity(intent3);
    }

}