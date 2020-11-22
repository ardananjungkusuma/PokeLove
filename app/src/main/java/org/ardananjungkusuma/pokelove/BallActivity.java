package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ardananjungkusuma.pokelove.models.Ball;
import org.ardananjungkusuma.pokelove.models.BallAdapter;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BallActivity extends AppCompatActivity implements BallAdapter.OnBallClickListener {


    public static final String Key_BallActivity = "Key_BallActivity";

    private RecyclerView rv;
    private BallAdapter ballAdapter;
    private EditText searchText;
    public RecyclerView.LayoutManager layoutManager;
    public List<Ball> listBall = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        rv = (RecyclerView) findViewById(R.id.rvBall);
        searchText = (EditText) findViewById(R.id.txtSearchBall);
        listBall.add(new Ball(
                "Poké Ball", "1x", "Type of Poké Ball introduced in Generation I. It is the most basic form of Poké Ball, an item used to catch a wild Pokémon. \n" +
                "The eponymous Poké Ball is the most ubiquitous kind of Poké Ball across the entire Pokémon franchise. It is frequently used to represent the Pokémon series as a whole, such as in the Pokémon series' icon in the Super Smash Bros. series", "I", "Must be in the player's bag with an empty space in the party to obtain a Shedinja when Nincada evolves from Generation IV onwards.", "https://cdn.bulbagarden.net/upload/7/79/Dream_Pok%C3%A9_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Great Ball", "1.5x", "Type of Poké Ball introduced in Generation I. It is an improved variant of the regular Poké Ball that can be used to catch wild Pokémon.", "I", "-", "https://cdn.bulbagarden.net/upload/b/bf/Dream_Great_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Ultra Ball", "2x", "Type of Poké Ball introduced in Generation I. It is an improved variant of the Great Ball that can be used to catch wild Pokémon.", "I", "-", "https://cdn.bulbagarden.net/upload/a/a8/Dream_Ultra_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Master Ball", "255x", "Type of Poké Ball introduced in Generation I. It can be used to catch a wild Pokémon without fail.\n" +
                "\n" +
                "The Master Ball, like all Poké Balls, is spherical in shape. The top and bottom halves are divided by a horizontal black band, on which the button is found on all Poké Balls. The top half of the Master Ball is purple, with a white letter \"M\" on the front, with a pink circle on either side. Master Balls are developed by Silph Co.", "I", "-", "https://cdn.bulbagarden.net/upload/9/95/Dream_Master_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Safari Ball", "1.5x", "Type of Poké Ball introduced in Generation I. It can be used to catch wild Pokémon during a Safari Game.", "I", "Prior to Generation VIII, it could not be obtained in normal gameplay, and was only usable within Safari Zones.", "https://cdn.bulbagarden.net/upload/1/15/Dream_Safari_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Fast Ball", "4× if used on a Pokémon with a base Speed of at least 100\n" +
                "1× otherwise", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon, being more likely to succeed against Pokémon that are fast or quick to flee.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from White Apricorns.", "II", "-", "https://cdn.bulbagarden.net/upload/4/44/Dream_Fast_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Level Ball", "1× if the player's Pokémon is the same level as or a lower level than the wild Pokémon\n" +
                "2× if the player's Pokémon is at a higher level than the wild Pokémon but less than double it\n" +
                "4× if the player's Pokémon is more than double but less than four times the level of the wild Pokémon\n" +
                "8× if the player's Pokémon is of a level four times or more than that of the wild Pokémon", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon, being more likely to succeed the higher the Trainer's Pokémon's level is than the wild Pokémon's.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from Red Apricorns.", "II", "-", "https://cdn.bulbagarden.net/upload/1/19/Dream_Level_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Lure Ball", "5× if used on a Pokémon encountered while fishing\n" +
                "1× otherwise", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon, being more likely to succeed in fishing encounters.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from Blue Apricorns.", "II", "-", "https://cdn.bulbagarden.net/upload/b/bd/Dream_Lure_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Heavy Ball", "-20 if used on a Pokémon weighing 220.2 lbs. (99.9 kg) or less\n" +
                "±0 if used on a Pokémon weighing 220.5 lbs. (100.0 kg) – 440.7 lbs. (199.9 kg)\n" +
                "+20 if used on a Pokémon weighing 440.9 lbs. (200.0 kg) – 661.2 lbs. (299.9 kg)\n" +
                "+30 if used on a Pokémon weighing 661.4 lbs. (300.0 kg) or more", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon, being more likely to succeed the heavier the Pokémon is.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from Black Apricorns.", "II", "-", "https://cdn.bulbagarden.net/upload/b/bb/Dream_Heavy_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Love Ball", "8× if used on a Pokémon of the same species but opposite gender of the player's Pokémon\n" +
                "1× otherwise", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon, being more likely to succeed against a Pokémon of the opposite gender to the Trainer's Pokémon.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from Pink Apricorns.", "II", "-", "https://cdn.bulbagarden.net/upload/9/94/Dream_Love_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Friend Ball", "1x", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon. Pokémon caught in a Friend Ball become more friendly.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from Green Apricorns.", "II", "Sets caught Pokémon's friendship to 200.", "https://cdn.bulbagarden.net/upload/7/7a/Dream_Friend_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Moon Ball", "4× if used on a Pokémon that belongs to an evolutionary family which includes a Pokémon that evolves by using a Moon Stone\n" +
                "1× otherwise", "Type of Poké Ball introduced in Generation II. It can be used to catch a wild Pokémon, being more likely to succeed against Pokémon that evolve by using Moon Stone and their evolutionary relatives.\n" +
                "\n" +
                "It is one of Kurt's signature Apricorn Poké Balls, and is made from Yellow Apricorns.", "II", "-", "https://cdn.bulbagarden.net/upload/2/22/Dream_Moon_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Sport Ball", "1.5x", "The Sport Ball (Japanese: コンペボール Compé Ball), called the Park Ball (Japanese: パークボール Park Ball) in Generation II, is a type of Poké Ball introduced in Generation II. It can be used to catch wild Pokémon during a Bug-Catching Contest at National Park.\n" +
                "\n" +
                "This Poké Ball's name was changed due to the introduction of a different Poké Ball called a Park Ball in Generation IV.", "II", "Prior to Generation VIII, it could not be obtained in normal gameplay, and was only usable during the Bug-Catching Contest.", "https://cdn.bulbagarden.net/upload/d/df/Dream_Sport_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Net Ball", "3.5× if used on a Water- or Bug-type Pokémon\n" +
                "1× otherwise", "The Net Ball (Japanese: ネットボール Net Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon, being more likely to succeed against a Water- and Bug-type Pokémon.", "III", "-", "https://cdn.bulbagarden.net/upload/a/a0/Dream_Net_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Nest Ball", "((41 - Pokémon's level) ÷ 10)× if Pokémon's level is between 1 and 29\n" +
                "1× otherwise", "The Nest Ball (Japanese: ネストボール Nest Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon, being more likely to succeed against lower level Pokémon.", "III", "-", "https://cdn.bulbagarden.net/upload/8/8c/Dream_Nest_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Repeat Ball", "\t3.5× if used on a Pokémon that is registered in the player's Pokédex as caught\n" +
                "1× otherwise", "The Repeat Ball (Japanese: リピートボール Repeat Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon, being more likely to succeed if the Pokémon is already registered as caught in the Trainer's Pokédex.", "III", "-", "https://cdn.bulbagarden.net/upload/d/df/Dream_Repeat_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Timer Ball", "(1 + number of turns passed in battle * 1229/4096)×, maximum 4× at 10 turns", "The Timer Ball (Japanese: タイマーボール Timer Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon, being more likely to succeed the longer it has been since the start of the battle.", "III", "-", "https://cdn.bulbagarden.net/upload/f/f0/Dream_Timer_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Luxury Ball", "1x", "The Luxury Ball (Japanese: ゴージャスボール Gorgeous Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon. Pokémon caught in a Luxury Ball gain friendship more quickly.", "III", "Doubles the rate in which the contained Pokémon receives friendship", "https://cdn.bulbagarden.net/upload/7/7e/Dream_Luxury_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Premier Ball", "1x", "The Premier Ball (Japanese: プレミアボール Premier Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon.", "III", "-", "https://cdn.bulbagarden.net/upload/6/64/Dream_Premier_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Dive Ball", "3.5× if used on a water-dwelling Pokémon\n" +
                "1× otherwise", "The Dive Ball (Japanese: ダイブボール Dive Ball) is a type of Poké Ball introduced in Generation III. It can be used to catch a wild Pokémon, being more likely to succeed in water encounters, originally specifically underwater encounters.", "III", "-", "https://cdn.bulbagarden.net/upload/9/9a/Dream_Dive_Ball_Sprite.png"
        ));
        listBall.add(new Ball(
                "Dusk Ball", "3× if used in a cave or at night\n" +
                "1× otherwise", "The Dusk Ball (Japanese: ダークボール Dark Ball) is a type of Poké Ball introduced in Generation IV. It can be used to catch a wild Pokémon, being more likely to succeed if used at night or in a cave.", "IV", "-", "https://cdn.bulbagarden.net/upload/5/59/Dream_Dusk_Ball_Sprite.png"
        ));

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });


        ballAdapter = new BallAdapter(listBall);
        ballAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(ballAdapter);
        rv.setLayoutManager(layoutManager);
    }


    public void back(View view) {
        Intent i = new Intent(BallActivity.this, MainActivity.class);
        startActivity(i);
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<Ball> filterBall = new ArrayList<>();

        //looping through existing elements
        for (Ball b : listBall) {
            //if the existing elements contains the search input
            if (b.getName().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterBall.add(b);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        ballAdapter.filterList(filterBall);
    }


    @Override
    public void onClick(View view, int position) {
        Ball ball = listBall.get(position);
//        Toast.makeText(this, ball.getName(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(BallActivity.this, BallDetailActivity.class);
        i.putExtra(Key_BallActivity, ball);
        startActivity(i);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(BallActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showNews() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LearnElement le = new LearnElement();
        fragmentTransaction.add(R.id.infoNews, le, "newsFlash");

        fragmentTransaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        showNews();
    }

}