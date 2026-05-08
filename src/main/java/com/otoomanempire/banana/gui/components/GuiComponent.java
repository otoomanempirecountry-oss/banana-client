package com.otoomanempire.banana.gui.components;

public interface GuiComponent {
    void render(float partialTicks);
    void onClick(double mouseX, double mouseY, int button);
    boolean isHovered(double mouseX, double mouseY);
}
