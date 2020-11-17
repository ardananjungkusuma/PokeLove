package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void contactMe(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ardananjungkusuma@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "");
        i.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(i.createChooser(i, "Choose Email"));
    }

    public void back(View view) {
        Intent i = new Intent(Info.this, MainActivity.class);
        startActivity(i);
    }
}