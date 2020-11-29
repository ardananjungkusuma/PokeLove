package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.ardananjungkusuma.pokelove.models.Element;

public class ElementDetailActivity extends AppCompatActivity {
    private TextView txtTitle,txtName, txtDesc, txtDefense, txtOffense, txtContestProperties;
    private ImageView imgElement;

    public static final String Key_ElementActivity = "Key_ElementActivity";

    Element element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);
        txtName = (TextView) findViewById(R.id.detNameElement);
        txtDesc = (TextView) findViewById(R.id.detDescElement);
        txtDefense = (TextView) findViewById(R.id.detDefenseElement);
        txtOffense = (TextView) findViewById(R.id.detOffenseElement);
        txtContestProperties = (TextView) findViewById(R.id.detContestPropertiesElement);
        imgElement = (ImageView) findViewById(R.id.detImageElement);
        txtTitle = (TextView) findViewById(R.id.txtDetailTitle);

        element = getIntent().getParcelableExtra(Key_ElementActivity);

        txtTitle.setText(element.getName());
        txtName.setText(element.getName());
        txtDesc.setText(element.getDescription());
        txtDefense.setText(element.getDefense());
        txtOffense.setText(element.getOffense());
        txtContestProperties.setText(element.getContestProperties());
        Picasso.get().load(element.getImg()).into(imgElement);
    }

    public void backToElementDex(View view) {
        Intent i = new Intent(ElementDetailActivity.this, ElementActivity.class);
        startActivity(i);
    }
}