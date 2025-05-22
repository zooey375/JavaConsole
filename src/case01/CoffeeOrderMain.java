package case01;

import java.util.Map;

public class CoffeeOrderMain {

	public static void main(String[] args) {
		// 價格對照表
		/*
		 {"latte":{"S", 50}, {"M", 70}, {"L", 90}}
		 {"mocha":{"S", 45}, {"M", 55}, {"L", 65}} 
		 ... 
		*/
		Map<String, Map<String, Integer>> priceTable = Map.of(
				"latte", Map.of("S", 50, "M", 70, "L", 90),
				"mocha", Map.of("S", 45, "M", 55, "L", 65),
				"americano", Map.of("S", 40, "M", 45, "L", 60),
				"cappuccino", Map.of("S", 55, "M", 80, "L", 100));
		
		System.out.println(priceTable);
		System.out.println(priceTable.get("latte").get("M"));
		
		CoffeeOrder coffeeOrder = new CoffeeOrder("latte", "M", "true");
		System.out.println(coffeeOrder.getInfo());
	}

}
