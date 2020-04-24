/**
 * 
 */
package com.java.Bridge;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author
 *
 */
public class LongBridgeDetails implements LongBridge{

	public int northEndCars;
	public int southEndCars;
	public boolean priorityForsouth;

	public LongBridgeDetails(int s, int n) {
		this.southEndCars = s;
		this.northEndCars = n;
		if (southEndCars >= northEndCars) {
			priorityForsouth = true;
		}else
		priorityForsouth = false;
	}


	/**
	 * waiting for 1 seconds before car passes through bridge
	 */
	public void oneCarPasses() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (priorityForsouth) {
			southEndCars--;
		} else {
			northEndCars--;
		}
		if (priorityForsouth)
			System.out.println(southEndCars + " southbound cars remain, " + northEndCars + " northbound cars");
		else
			System.out.println(northEndCars + " northbound cars remain, " + southEndCars + " southbound cars");

	}

	/**
	 * If both ends are reached to equal number of cars we are changing the priority
	 * value
	 */
	public void bothEndsEquals() {
		if (priorityForsouth) {

			priorityForsouth = false;
			System.out.println("Northbound = southbound: Priority is Northbound");
		} else {
			priorityForsouth = true;
			System.out.println("Northbound = southbound: Priority is Southbound");
		}
	}

	/**
	 * Every 3 seconds we are adding new car in the both ends of the bridge and if
	 * priority changes based on conditions
	 */

	public void addNewCar() {
		southEndCars++;
		northEndCars++;
		System.out.println("3 seconds done. One car added to each direction.");
		System.out.println("Total southbound: " + southEndCars + " Total northbound " + northEndCars);
		if (southEndCars > northEndCars && !priorityForsouth) {
			System.out.println("southbound > northbound. Priority changes to southbound");
			priorityForsouth = true;
		} else if (southEndCars < northEndCars && priorityForsouth) {
			System.out.println("southbound < northbound. Priority changes to northbound");
			priorityForsouth = false;
		}
	}
	
	/**
	 * perform operation on the number of cars in each end and based Priority value
	 * perform passing car from one end to other
	 */
	public void passingBridge() {
		if (southEndCars >= northEndCars) {
			System.out.println("southbound > northbound : Priority is southbound ");
		}else
		{
			System.out.println("southbound < northbound : Priority is northbound ");
		}

		int reset = 0;
		while (southEndCars > 0 || northEndCars > 0) {
			oneCarPasses();
			if (southEndCars == 0 && northEndCars == 0) {
				break;
			}
			if (southEndCars == northEndCars) {
				bothEndsEquals();
			}
			reset += 1000;
			if (reset == 3000) {
				addNewCar();
				reset = 0;
			}

			if (southEndCars == 0 && northEndCars != 0 && priorityForsouth) {
				System.out.println("southbound becomes zero cars. Priority changes to northbound");
				priorityForsouth = false;
			} else if (northEndCars == 0 && southEndCars != 0 && !priorityForsouth) {
				System.out.println("northbound becomes zero cars. Priority changes to southbound");
				priorityForsouth = true;
			}

		}
	}
	
	  public static void main(String[] args) throws IOException {
	      System.out.println("Enter the number of south end cars");
	      @SuppressWarnings("resource")
		  Scanner scan = new Scanner(System.in);
	      int s = scan.nextInt();
	      System.out.println("Enter the number of North end cars");
	      int n = scan.nextInt();
	      LongBridge bridge = new LongBridgeDetails(s,n);
	      bridge.passingBridge();
	      
	  }

}
