package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.ardananjungkusuma.pokelove.databinding.ActivityInfoBinding;
import org.ardananjungkusuma.pokelove.models.Info;

public class InfoActivity extends AppCompatActivity {

    ActivityInfoBinding infoBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoBinding = DataBindingUtil.setContentView(this, R.layout.activity_info);
        Info info = new Info("Ardan Anjung Kusuma", "PokeLove is simple pokedex that provides many data about Pokemon, Pokeball, Elementdex and Element Chart!", R.drawable.developer);
        infoBinding.setInfo(info);
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
        Intent i = new Intent(InfoActivity.this, MainActivity.class);
        startActivity(i);
    }
}