package com.otoomanempire.banana;

import com.otoomanempire.banana.events.KeyInputHandler;
import com.otoomanempire.banana.gui.ClickGui;
import com.otoomanempire.banana.features.KillAura;

public class BananaClient {
    public static final String VERSION = "1.0.0";
    public static final String MOD_ID = "banana-client";
    
    private static BananaClient instance;
    private ClickGui clickGui;
    private KillAura killAura;
    
    public BananaClient() {
        instance = this;
        this.clickGui = new ClickGui();
        this.killAura = new KillAura();
    }
    
    public static void initialize() {
        new BananaClient();
    }
    
    public static BananaClient getInstance() {
        return instance;
    }
    
    public ClickGui getClickGui() {
        return clickGui;
    }
    
    public KillAura getKillAura() {
        return killAura;
    }
    
    public void onClientTick() {
        if (killAura.isEnabled()) {
            killAura.onTick();
        }
    }
}