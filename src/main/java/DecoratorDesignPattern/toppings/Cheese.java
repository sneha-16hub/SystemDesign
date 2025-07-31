package DecoratorDesignPattern.toppings;

import DecoratorDesignPattern.Pizza.BasePizza;

public class Cheese extends ToppingDecorator{
	BasePizza pizza;
    public Cheese(BasePizza p) {
    	this.pizza=p;
    }
	@Override
	public int cost() {
		
		return this.pizza.cost()+10;
	}

}
