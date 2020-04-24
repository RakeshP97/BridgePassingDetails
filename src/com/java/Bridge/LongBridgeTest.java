package com.java.Bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongBridgeTest {
	
	@Test
	public void testOneCarPasses()
	{
		LongBridgeDetails bridge = new LongBridgeDetails(3,3);
		bridge.oneCarPasses();
		assertEquals(2, bridge.southEndCars);		
	}
	
	@Test
	public void testBothEndsEquals()
	{
		LongBridgeDetails bridge = new LongBridgeDetails(3,3);
		bridge.bothEndsEquals();
		assertEquals(false, bridge.priorityForsouth);
	}

	@Test
	public void testAddNewCar()
	{
		LongBridgeDetails bridge = new LongBridgeDetails(2,3);
		bridge.addNewCar();
		assertEquals(3, bridge.southEndCars);		
		assertEquals(4, bridge.northEndCars);		
		assertEquals(false, bridge.priorityForsouth);

	}
	@Test
	public void testPassingBridge() {
		LongBridgeDetails bridge = new LongBridgeDetails(4,3);
		bridge.passingBridge();
		assertEquals(0, bridge.southEndCars);		
		assertEquals(0, bridge.northEndCars);		
	}
}
