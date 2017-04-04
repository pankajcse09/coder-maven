package org.coder.design.patterns.creational.iabstract;

import org.coder.design.patterns.creational.iabstract.Computer;
import org.coder.design.patterns.creational.iabstract.ComputerAbstractFactory;
import org.coder.design.patterns.creational.iabstract.Laptop;

public class LaptopFactory implements ComputerAbstractFactory {
	
	private String ram;
	private String hdd;
	private String cpu;

	public LaptopFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	public Computer getComputerObj() {
		return new Laptop(ram, hdd, cpu);
	}

}
