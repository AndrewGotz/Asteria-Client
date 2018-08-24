package com.runescape.util.ondemand;

import com.runescape.world.NodeSub;

public final class OnDemandData extends NodeSub {

    public OnDemandData() {
        incomplete = true;
    }

    public int dataType;
    public byte buffer[];
    public int ID;
    public boolean incomplete;
    public int loopCycle;
}
