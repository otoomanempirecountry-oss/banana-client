package com.otoomanempire.banana.gui.components;

public class Button implements GuiComponent {
    private String label;
    private int x, y, width, height;
    private Runnable clickAction;
    private boolean toggleable;
    private boolean toggled;
    private boolean hovered;
    
    public Button(String label, int x, int y, int width, int height, Runnable clickAction) {
        this.label = label;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.clickAction = clickAction;
        this.toggleable = false;
        this.toggled = false;
        this.hovered = false;
    }
    
    @Override
    public void render(float partialTicks) {
        // Render button background
        int backgroundColor = hovered ? 0xFF3d3d3d : 0xFF2d2d2d;
        if (toggled && toggleable) {
            backgroundColor = 0xFF00AA00; // Green when toggled on
        }
        drawRect(x, y, x + width, y + height, backgroundColor);
        
        // Render button text (you'll need a text renderer)
        String displayText = label;
        if (toggleable) {
            displayText += toggled ? " [ON]" : " [OFF]";
        }
        // drawString(displayText, x + 5, y + height / 2 - 4);
    }
    
    @Override
    public void onClick(double mouseX, double mouseY, int button) {
        if (button == 0) { // Left click
            if (toggleable) {
                toggled = !toggled;
            }
            if (clickAction != null) {
                clickAction.run();
            }
        }
    }
    
    @Override
    public boolean isHovered(double mouseX, double mouseY) {
        hovered = mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
        return hovered;
    }
    
    public void setToggleable(boolean toggleable) {
        this.toggleable = toggleable;
    }
    
    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }
    
    public boolean isToggled() {
        return toggled;
    }
    
    private void drawRect(int x1, int y1, int x2, int y2, int color) {
        // Implementation depends on your rendering framework
    }
}