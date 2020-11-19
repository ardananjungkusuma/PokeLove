package org.ardananjungkusuma.pokelove.viewmodels;

import androidx.lifecycle.ViewModel;

import org.ardananjungkusuma.pokelove.R;
import org.ardananjungkusuma.pokelove.models.SnorlaxGame;

public class SnorlaxGameActivityViewModel extends ViewModel {
    public int tapCount = 0;

    SnorlaxGame sg = new SnorlaxGame(0, R.drawable.snoresleep,"Snorlax is sleeping, ssstt...");

    public void tapping(){
        sg.setTap(sg.getTap()+1);
    }

    public int getTapCount() {
        return sg.getTap();
    }

    public String getStatusSnorlax(){
        return sg.getStatus();
    }

    public void setStatusSnorelax(String status){
        sg.setStatus(status);
    }

    public void setImgSnorlax(int img){
        sg.setImg(img);
    }

    public int getImgSnorlax(){
        return sg.getImg();
    }
}
