package com.example.login1.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {
    String cuenta = "Estado";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnCerrar = (Button) findViewById(R.id.Cerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarCerrar();
            }
        });
    }
    private void cambiarCerrar(){
        try{
            FileOutputStream fileOutputStream =
                    openFileOutput(cuenta, Context.MODE_PRIVATE);

            //MODE_APPEND, MODE_WORLD_READABLE, and MODE_WORLD_WRITEABLE

            fileOutputStream.write("desactive".getBytes());
            fileOutputStream.close();
        }
        catch (FileNotFoundException e) {}
        catch (IOException e) {}
        Intent change = new Intent(this, LoginActivity.class);
        startActivityForResult(change, 0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
