package DecoratorDesignPattern;
import DecoratorDesignPattern.Pizza.BasePizza;
import DecoratorDesignPattern.Pizza.Margretta;
import DecoratorDesignPattern.toppings.ToppingDecorator;
import DecoratorDesignPattern.toppings.Cheese;
public class CalculateCost {

	public static void main(String[] args) {
		BasePizza pizza=new Margretta();
		ToppingDecorator p=new Cheese(pizza);
		System.out.println(p.cost());
		

	}

}
