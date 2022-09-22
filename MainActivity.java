package com.example.regform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.regform.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button s;
    EditText n,p;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("MyPref",MODE_PRIVATE);
        s=(Button) findViewById(R.id.sub);
        n=(EditText) findViewById(R.id.name);
        p=(EditText) findViewById(R.id.pass);
        s.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String a=n.getText().toString();
        String b=n.getText().toString();
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("Name",a);
        edit.putString("pwd",b);
        edit.apply();
        Toast.makeText(this,"Registration Submitted",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,SecondActivity.class));
    }
}
