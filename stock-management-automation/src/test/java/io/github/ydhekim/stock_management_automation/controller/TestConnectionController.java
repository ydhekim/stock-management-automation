package io.github.ydhekim.stock_management_automation.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConnectionController {

	@Test
    public void testGetConnection(){
		ConnectionController conn = new ConnectionController();
		assertTrue(conn.Connect());
    }

}
