package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ElementDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);
    }

    public void backToElementDex(View view) {
        Intent i = new Intent(ElementDetailActivity.this, ElementActivity.class);
        startActivity(i);
    }
}