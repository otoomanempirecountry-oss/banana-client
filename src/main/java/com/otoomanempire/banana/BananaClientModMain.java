package com.otoomanempire.banana;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BananaClientModMain implements ModInitializer {
    public static final String MOD_ID = "banana-client";
    public static final String MOD_NAME = "Banana Client";
    public static final String MOD_VERSION = "1.0.0";
    
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing {} v{}", MOD_NAME, MOD_VERSION);
        BananaClient.initialize();
    }
}
