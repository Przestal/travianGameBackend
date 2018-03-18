package com.sda.webgame.model;

import java.time.LocalDateTime;

public class UpgradeStatus {

    private UpgradeState upgradeState;
    private LocalDateTime upgradeFinishTime;


    public UpgradeStatus(UpgradeState upgradeState, LocalDateTime upgradeFinishTime) {
        this.upgradeState = upgradeState;
        this.upgradeFinishTime = upgradeFinishTime;
    }

    public UpgradeStatus() {
    }

    public UpgradeState getUpgradeState() {
        return upgradeState;
    }

    public void setUpgradeState(UpgradeState upgradeState) {
        this.upgradeState = upgradeState;
    }

    public LocalDateTime getUpgradeFinishTime() {
        return upgradeFinishTime;
    }

    public void setUpgradeFinishTime(LocalDateTime upgradeFinishTime) {
        this.upgradeFinishTime = upgradeFinishTime;
    }
}
