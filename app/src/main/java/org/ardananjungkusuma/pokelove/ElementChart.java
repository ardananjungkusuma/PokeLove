package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ElementChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_chart);

        TouchImageView imViewedImage = findViewById(R.id.elementChart);
    }

    public void back(View view) {
        Intent i = new Intent(ElementChart.this, MainActivity.class);
        startActivity(i);
    }
}