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
#secndact
package com.example.regform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.regform.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
Button l1,p1;
String username,password;
EditText user,pwd;
SharedPreferences sp;
Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sp=getSharedPreferences("MyPref",MODE_PRIVATE);
        user=(EditText) findViewById(R.id.name);
        pwd=(EditText) findViewById(R.id.pass);
        l1.setOnClickListener(this);
        l1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.previous)
            startActivity(new Intent(this,MainActivity.class));
        if(v.getId()==R.id.login)
        {
            username=user.getText().toString();
            password=pwd.getText().toString();
            Toast t1;
            if((username.equals(sp.getString("Name",""))) && (password.equals(sp.getString("pwd",""))))
            {
                t1=Toast.makeText(this," ",Toast.LENGTH_LONG);
                t1.setGravity(Gravity.TOP,0,200);
                LayoutInflater Lin=getLayoutInflater();
                View appear=Lin.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_linear_layout));
                t1.setView(appear);
                t1.show();
            }
            else
            {
                Toast.makeText(this,"Invalid Login",Toast.LENGTH_LONG).show();
            }


        }
    }
}

