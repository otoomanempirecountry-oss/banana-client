package com.otoomanempire.banana.gui.components;

import java.util.ArrayList;
import java.util.List;

public class Panel {
    private String title;
    private int x, y, width, height;
    private List<GuiComponent> components;
    private double lastMouseX, lastMouseY;
    private boolean dragging;
    
    public Panel(String title, int x, int y, int width, int height) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.components = new ArrayList<>();
        this.dragging = false;
    }
    
    public void addComponent(GuiComponent component) {
        components.add(component);
    }
    
    public void render(float partialTicks) {
        // Render panel background
        renderBackground();
        
        // Render panel header with title
        renderHeader();
        
        // Render all components
        for (GuiComponent component : components) {
            component.render(partialTicks);
        }
    }
    
    private void renderBackground() {
        // Draw semi-transparent background
        int backgroundColor = 0xFF1a1a1a;
        drawRect(x, y + 20, x + width, y + height, backgroundColor);
    }
    
    private void renderHeader() {
        // Draw header bar
        int headerColor = 0xFF2d2d2d;
        drawRect(x, y, x + width, y + 20, headerColor);
        
        // Render title text (simplified - you'll need a text renderer)
        // drawString(title, x + 5, y + 6);
    }
    
    public void onMouseClick(double mouseX, double mouseY, int button) {
        for (GuiComponent component : components) {
            if (component.isHovered(mouseX, mouseY)) {
                component.onClick(mouseX, mouseY, button);
            }
        }
    }
    
    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
    
    public boolean isInHeader(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 20;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void setLastMousePosition(double x, double y) {
        this.lastMouseX = x;
        this.lastMouseY = y;
    }
    
    public double getLastMouseX() { return lastMouseX; }
    public double getLastMouseY() { return lastMouseY; }
    
    private void drawRect(int x1, int y1, int x2, int y2, int color) {
        // Implementation depends on your rendering framework
        // This is a placeholder
    }
}