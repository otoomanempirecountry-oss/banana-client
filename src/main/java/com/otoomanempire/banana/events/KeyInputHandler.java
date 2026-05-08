package com.otoomanempire.banana.events;

import com.otoomanempire.banana.BananaClient;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    private static final int GUI_TOGGLE_KEY = GLFW.GLFW_KEY_B; // B key
    
    public static void onKeyInput(int key, int scancode, int action, int mods) {
        if (action != GLFW.GLFW_PRESS) {
            return;
        }
        
        if (key == GUI_TOGGLE_KEY) {
            BananaClient.getInstance().getClickGui().toggle();
        }
    }
}