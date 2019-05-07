package com.devoxx4kids.species;

import com.devoxx4kids.ui.EventCtx;

public interface GAMachineObserver {

    void gaEventOccured(GAEvent gaEvent, EventCtx eventCtx);
}
