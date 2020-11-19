package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.squareup.picasso.Picasso;

import org.ardananjungkusuma.pokelove.databinding.ActivitySnorlaxGameBinding;
import org.ardananjungkusuma.pokelove.models.SnorlaxGame;
import org.ardananjungkusuma.pokelove.viewmodels.SnorlaxGameActivityViewModel;

public class SnorlaxGameActivity extends AppCompatActivity {

    private SnorlaxGameActivityViewModel snorlaxGameActivityViewModel;
    ActivitySnorlaxGameBinding bind;
    int rangeWakeup = (int) ((Math.random() * (40 - 25)) + 25);
    int rangeMoveLilBit = (int) ((Math.random() * (23 - 17)) + 17);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_snorlax_game);
        snorlaxGameActivityViewModel = new ViewModelProvider(this).get(SnorlaxGameActivityViewModel.class);
        bind.setViewModel(snorlaxGameActivityViewModel);
        snorlaxGameActivityViewModel.setStatusSnorelax("Snorlax is sleeping, ssstt...");
        bind.statusSnorlax.setText(snorlaxGameActivityViewModel.getStatusSnorlax());
        bind.txtTap.setText(String.valueOf(snorlaxGameActivityViewModel.getTapCount()));
        snorlaxGameActivityViewModel.setImgSnorlax(R.drawable.snoresleep);
        bind.imageSnorlax.setImageResource(snorlaxGameActivityViewModel.getImgSnorlax());
        bind.btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind.getViewModel().tapping();
                bind.txtTap.setText(String.valueOf(snorlaxGameActivityViewModel.getTapCount()));
                if (snorlaxGameActivityViewModel.getTapCount() == rangeMoveLilBit) {
                    snorlaxGameActivityViewModel.setStatusSnorelax("Snorlax is moving bit...\nBut still sleep! Keep Tapping!");
                    bind.statusSnorlax.setText(snorlaxGameActivityViewModel.getStatusSnorlax());
                } else if (snorlaxGameActivityViewModel.getTapCount() > rangeWakeup) {
                    snorlaxGameActivityViewModel.setStatusSnorelax("Snorlax is wake up! XD");
                    bind.statusSnorlax.setText(snorlaxGameActivityViewModel.getStatusSnorlax());
                    snorlaxGameActivityViewModel.setImgSnorlax(R.drawable.snorelaxwokeup);
                    bind.imageSnorlax.setImageResource(snorlaxGameActivityViewModel.getImgSnorlax());
                    bind.btnTap.setEnabled(false);
                    bind.btnTap.setText("Snorlax Already Wake UP");
                    bind.btnTap.setClickable(false);
                }
            }
        });
        bind.setLifecycleOwner(this);
    }

    public void backToMainMenu(View view) {
        Intent i = new Intent(SnorlaxGameActivity.this, MainActivity.class);
        startActivity(i);
    }
}