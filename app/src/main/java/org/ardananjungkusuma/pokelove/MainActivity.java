package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void infoClick(View view) {
        Intent i = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(i);
    }

    public void elementChart(View view) {
        Intent i = new Intent(MainActivity.this, ElementChart.class);
        startActivity(i);
    }

    public void ballDex(View view) {
        Intent i = new Intent(MainActivity.this, BallActivity.class);
        startActivity(i);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void snorlaxGame(View view) {
        Intent i = new Intent(MainActivity.this, SnorlaxGameActivity.class);
        startActivity(i);
    }

    public void elementDex(View view) {
        Intent i = new Intent(MainActivity.this, ElementActivity.class);
        startActivity(i);
    }

    public void pokedex(View view) {
        Intent i = new Intent(MainActivity.this, PokemonActivity.class);
        startActivity(i);
    }
}