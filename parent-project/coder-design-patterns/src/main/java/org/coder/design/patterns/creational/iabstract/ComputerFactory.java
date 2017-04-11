package org.coder.design.patterns.creational.iabstract;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.getComputerObj();
	}
}
