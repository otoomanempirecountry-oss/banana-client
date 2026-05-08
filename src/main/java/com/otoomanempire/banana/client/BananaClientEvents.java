package com.otoomanempire.banana.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.otoomanempire.banana.BananaClient;
import com.otoomanempire.banana.BananaClientModMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class BananaClientEvents implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BananaClientModMain.MOD_NAME);
    private static KeyBinding guiToggleKey;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing {} Client Events", BananaClientModMain.MOD_NAME);
        
        // Register key binding
        guiToggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.banana-client.gui_toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                "category.banana-client"
        ));
        
        // Register client tick event
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (guiToggleKey.wasPressed()) {
                BananaClient.getInstance().getClickGui().toggle();
            }
            BananaClient.getInstance().onClientTick();
        });
        
        // Register client lifecycle events
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            LOGGER.info("{} client has started", BananaClientModMain.MOD_NAME);
        });
        
        ClientLifecycleEvents.CLIENT_STOPPING.register(client -> {
            LOGGER.info("{} client is stopping", BananaClientModMain.MOD_NAME);
        });
    }
}
