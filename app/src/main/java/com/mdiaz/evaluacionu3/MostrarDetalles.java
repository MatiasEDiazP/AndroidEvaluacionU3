package com.mdiaz.evaluacionu3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MostrarDetalles extends AppCompatActivity{
    private TextView textViewValorSensor,textViewNombreSensor,textViewFechaHora,textViewUbicacionSensor,textViewTipoSensor;
    private EditText editTextObservacion;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        textViewNombreSensor = (TextView) findViewById(R.id.textViewNombreSensor);
        textViewValorSensor = (TextView) findViewById(R.id.textViewValorSensor);
        textViewFechaHora = (TextView) findViewById(R.id.textViewFechaHora);
        textViewUbicacionSensor = (TextView) findViewById(R.id.textViewUbicacionSensor);
        editTextObservacion = (EditText) findViewById(R.id.editTextObservacion);
        textViewTipoSensor = (TextView) findViewById(R.id.textViewTipoSensor);

        mDatabase.child("Sensores").child("Valor del sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ValorDelSensor = snapshot.getValue(String.class);
                textViewValorSensor.setText(ValorDelSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores").child("Nombre de Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String NombreDeSensor = snapshot.getValue(String.class);
                textViewNombreSensor.setText(NombreDeSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores").child("Fecha y Hora").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String FechaYHora = snapshot.getValue(String.class);
                textViewFechaHora.setText(FechaYHora);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores").child("Observacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Observacion = snapshot.getValue(String.class);
                editTextObservacion.setText(Observacion);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores").child("Tipo de Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String TipoDeSensor = snapshot.getValue(String.class);
                textViewTipoSensor.setText(TipoDeSensor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        mDatabase.child("Sensores").child("Ubicacion del sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Ubicacion = snapshot.getValue(String.class);
                textViewUbicacionSensor.setText(Ubicacion);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });



    }

    public void guardarObservacion(View view){
        Map<String, Object> newObservacion = new HashMap<>();
        String Observacion2 = editTextObservacion.getText().toString();
        newObservacion.put("Observacion",Observacion2);
        mDatabase.child("Sensores").updateChildren(newObservacion).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MostrarDetalles.this,"Se ha actualizado la observacion!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //SOLUCIONAR PROBLEMA DE LOS BOTONES
    //AGREGAR MAS ELEMENTOS A FIREBASE

    public void regresar(View view){
        Intent anterior = new Intent(this,MainActivity.class);
        startActivity(anterior);
    }
}