package org.coder.design.patterns.creational.builder;

/**
 * @Problem An application needs to create the elements of a complex aggregate.
 *          The specification for the aggregate exists on secondary storage and
 *          one of many representations needs to be built in primary storage.
 */

/** "Product" */
class Pizza {
	
	@SuppressWarnings("unused")
	private String dough = "";
	@SuppressWarnings("unused")
	private String sauce = "";
	@SuppressWarnings("unused")
	private String topping = "";

	public void setDough(String dough) {
		this.dough = dough;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}
}

/** "Abstract Builder" */
abstract class PizzaBuilder {
	protected Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public void createNewPizzaProduct() {
		pizza = new Pizza();
	}

	public abstract void buildDough();

	public abstract void buildSauce();

	public abstract void buildTopping();
}

/** "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
	public void buildDough() {
		pizza.setDough("cross");
	}

	public void buildSauce() {
		pizza.setSauce("mild");
	}

	public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}

/** "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
	public void buildDough() {
		pizza.setDough("pan baked");
	}

	public void buildSauce() {
		pizza.setSauce("hot");
	}

	public void buildTopping() {
		pizza.setTopping("pepperoni+salami");
	}
}

/** "Director" */
class Waiter {
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(PizzaBuilder pb) {
		pizzaBuilder = pb;
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
}

/* A customer ordering a pizza. */
class IBuilder {
	/**
	 * @Intent Separate the construction of a complex object from its
	 *         representation so that the same construction process can create
	 *         different representations. Parse a complex representation, create
	 *         one of several targets.
	 */
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
		@SuppressWarnings("unused")
		PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();

		waiter.setPizzaBuilder(hawaiian_pizzabuilder);
		waiter.constructPizza();
		@SuppressWarnings("unused")
		Pizza pizza = waiter.getPizza();
	}
}
