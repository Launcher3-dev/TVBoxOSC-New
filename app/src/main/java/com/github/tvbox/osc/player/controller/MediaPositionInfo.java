package com.github.tvbox.osc.player.controller;

public class MediaPositionInfo {
    public String trackDuration;
    public String absTime;

    public MediaPositionInfo(String trackDuration, String absTime) {
        this.trackDuration = trackDuration;
        this.absTime = absTime;
    }
}
