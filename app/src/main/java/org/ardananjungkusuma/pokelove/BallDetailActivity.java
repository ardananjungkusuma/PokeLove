package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.ardananjungkusuma.pokelove.models.Ball;
import org.w3c.dom.Text;

public class BallDetailActivity extends AppCompatActivity {
    private TextView txtBallName, txtDebutGen, txtCatchRateModifier,txtAdditionalEffect, txtDescBall;
    private ImageView imgBall;

    public static final String Key_BallActivity="Key_BallActivity";

    Ball ball;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_detail);
        txtBallName = (TextView)findViewById(R.id.txtBallName);
        txtDebutGen = (TextView)findViewById(R.id.txtDebutGen);
        txtCatchRateModifier = (TextView)findViewById(R.id.txtCatchRateModifier);
        txtAdditionalEffect = (TextView)findViewById(R.id.txtAdditionalEffect);
        txtDescBall = (TextView)findViewById(R.id.txtDescBall);
        imgBall = (ImageView)findViewById(R.id.imgBallDetail);

        ball = getIntent().getParcelableExtra(Key_BallActivity);

        txtBallName.setText(ball.getName());
        txtDebutGen.setText(ball.getDebutGen());
        txtCatchRateModifier.setText(ball.getCatchRateModifier());
        txtAdditionalEffect.setText(ball.getAdditionalEffect());
        txtDescBall.setText(ball.getDescription());
        Picasso.get().load(ball.getImgUrl()).into(imgBall);
    }

    public void backToBalldex(View view) {
        Intent i = new Intent(BallDetailActivity.this, BallActivity.class);
        startActivity(i);
    }
}