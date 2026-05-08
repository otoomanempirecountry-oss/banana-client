package com.otoomanempire.banana;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BananaClientTest {
    private BananaClient client;

    @Before
    public void setUp() {
        // Initialize before each test
        client = BananaClient.getInstance();
    }

    @Test
    public void testClientInitialization() {
        assertNotNull("Client should be initialized", client);
        assertNotNull("Click GUI should be initialized", client.getClickGui());
        assertNotNull("Kill Aura should be initialized", client.getKillAura());
    }

    @Test
    public void testClickGuiToggle() {
        assertFalse("GUI should start invisible", client.getClickGui().isVisible());
        client.getClickGui().toggle();
        assertTrue("GUI should be visible after toggle", client.getClickGui().isVisible());
        client.getClickGui().toggle();
        assertFalse("GUI should be invisible after second toggle", client.getClickGui().isVisible());
    }

    @Test
    public void testKillAuraToggle() {
        assertFalse("Kill Aura should start disabled", client.getKillAura().isEnabled());
        client.getKillAura().toggle();
        assertTrue("Kill Aura should be enabled after toggle", client.getKillAura().isEnabled());
        client.getKillAura().toggle();
        assertFalse("Kill Aura should be disabled after second toggle", client.getKillAura().isEnabled());
    }

    @Test
    public void testKillAuraRange() {
        client.getKillAura().setRange(5.5f);
        assertEquals("Kill Aura range should be set", 5.5f, client.getKillAura().getRange(), 0.01f);
        
        client.getKillAura().setRange(15.0f);
        assertEquals("Kill Aura range should be clamped to max", 10.0f, client.getKillAura().getRange(), 0.01f);
        
        client.getKillAura().setRange(0.5f);
        assertEquals("Kill Aura range should be clamped to min", 1.0f, client.getKillAura().getRange(), 0.01f);
    }

    @Test
    public void testKillAuraDelay() {
        client.getKillAura().setDelayTicks(10);
        assertEquals("Kill Aura delay should be set", 10, client.getKillAura().getDelayTicks());
        
        client.getKillAura().setDelayTicks(-5);
        assertEquals("Kill Aura delay should not be negative", 0, client.getKillAura().getDelayTicks());
    }

    @Test
    public void testKillAuraSettings() {
        client.getKillAura().setAttackPlayers(true);
        assertTrue("Should attack players", client.getKillAura().shouldAttackPlayers());
        
        client.getKillAura().setAttackPlayers(false);
        assertFalse("Should not attack players", client.getKillAura().shouldAttackPlayers());
        
        client.getKillAura().setAttackMobs(true);
        assertTrue("Should attack mobs", client.getKillAura().shouldAttackMobs());
        
        client.getKillAura().setAttackMobs(false);
        assertFalse("Should not attack mobs", client.getKillAura().shouldAttackMobs());
    }
}
