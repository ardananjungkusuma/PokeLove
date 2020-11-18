package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;

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
    SnorlaxGame sg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_snorlax_game);
        snorlaxGameActivityViewModel = new ViewModelProvider(this).get(SnorlaxGameActivityViewModel.class);
        bind.setViewModel(snorlaxGameActivityViewModel);
        bind.txtTap.setText(String.valueOf(snorlaxGameActivityViewModel.getTapCount()));
//        Picasso.get().load(sg.getImg())
//                .placeholder(R.drawable.snorlaxsleep);
        bind.btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind.getViewModel().tapping();
                bind.txtTap.setText(String.valueOf(snorlaxGameActivityViewModel.getTapCount()));
                if(snorlaxGameActivityViewModel.getTapCount() > 20 && snorlaxGameActivityViewModel.getTapCount() < 30){
                    bind.statusSnorlax.setText("Snorlax is wake up! XD");
                    // TODO GAMBAR SNORLAXNYA XD
//                    Picasso.get().load(sg.getImg())
//                            .placeholder(R.drawable.snorlaxwkup);
                }else if(snorlaxGameActivityViewModel.getTapCount() >= 30){
                    bind.statusSnorlax.setText("Stop tapping!! Snorlax already wake up!");
                    bind.txtTap.setText("30");
                }
            }
        });
        bind.setLifecycleOwner(this);

    }
}