package com.otoomanempire.banana.gui;

import com.otoomanempire.banana.gui.components.Panel;
import com.otoomanempire.banana.gui.components.Button;
import com.otoomanempire.banana.BananaClient;

import java.util.ArrayList;
import java.util.List;

public class ClickGui {
    private boolean visible;
    private List<Panel> panels;
    private Panel activeDraggedPanel;
    
    public ClickGui() {
        this.visible = false;
        this.panels = new ArrayList<>();
        initializePanels();
    }
    
    private void initializePanels() {
        // Create main features panel
        Panel featurePanel = new Panel("Features", 10, 10, 200, 300);
        
        // Add Kill Aura toggle button
        Button killAuraButton = new Button("Kill Aura", 5, 25, 190, 20, () -> {
            BananaClient.getInstance().getKillAura().toggle();
        });
        killAuraButton.setToggleable(true);
        killAuraButton.setToggled(BananaClient.getInstance().getKillAura().isEnabled());
        featurePanel.addComponent(killAuraButton);
        
        // Add more feature buttons here
        panels.add(featurePanel);
    }
    
    public void toggle() {
        this.visible = !this.visible;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void render(float partialTicks) {
        if (!visible) {
            return;
        }
        
        // Enable GL blending for transparency
        enableBlending();
        
        for (Panel panel : panels) {
            panel.render(partialTicks);
        }
        
        disableBlending();
    }
    
    public void onMouseClick(double mouseX, double mouseY, int button) {
        if (!visible) {
            return;
        }
        
        for (Panel panel : panels) {
            if (panel.isHovered(mouseX, mouseY)) {
                if (panel.isInHeader(mouseX, mouseY)) {
                    activeDraggedPanel = panel;
                }
                panel.onMouseClick(mouseX, mouseY, button);
            }
        }
    }
    
    public void onMouseRelease(double mouseX, double mouseY, int button) {
        activeDraggedPanel = null;
    }
    
    public void onMouseDrag(double mouseX, double mouseY) {
        if (activeDraggedPanel != null) {
            activeDraggedPanel.setPosition(
                (int) (activeD raggedPanel.getX() + mouseX - activeDraggedPanel.getLastMouseX()),
                (int) (activeDraggedPanel.getY() + mouseY - activeDraggedPanel.getLastMouseY())
            );
            activeDraggedPanel.setLastMousePosition(mouseX, mouseY);
        }
    }
    
    private void enableBlending() {
        // OpenGL blending setup (implementation specific to your rendering engine)
    }
    
    private void disableBlending() {
        // OpenGL blending teardown
    }
    
    public List<Panel> getPanels() {
        return panels;
    }
}