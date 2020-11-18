package org.ardananjungkusuma.pokelove.viewmodels;

import androidx.lifecycle.ViewModel;

public class SnorlaxGameActivityViewModel extends ViewModel {
    public int tapCount = 0;

    public void tapping(){
        this.tapCount = this.tapCount+1;
    }

    public int getTapCount() {
        return tapCount;
    }
}
