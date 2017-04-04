package org.coder.design.patterns.creational.iabstract;

/**
 * @Problem:---------------------------------------------------------------
 * If an application is to be portable, it needs to encapsulate platform
 * dependencies. These "platforms" might include: windowing system, operating
 * system, database, etc. Too often, this encapsulation is not engineered in
 * advance, and lots of #ifdef case statements with options for all currently
 * supported platforms begin to procreate like rabbits throughout the code.
 * -------------------------------------------------------------------------
 **/
public class IAbstractFactory {
	/**
	 * @Intent Provide an interface for creating families of related or
	 *         dependent objects without specifying their concrete classes. A
	 *         hierarchy that encapsulates: many possible "platforms", and the
	 *         construction of a suite of "products". The new operator
	 *         considered harmful.
	 */
	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer laptopObject = ComputerFactory.getComputer(new LaptopFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer serverObject = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
		System.out.println("AbstractFactory PC Config:: "+laptopObject);
		System.out.println("AbstractFactory Server Config:: "+serverObject);
	}

}
