package java8.biconsumerpractise;

import java.util.HashMap;
import java.util.Map;

public class BiConsumerDemo1 {

	public static void main(String[] args) {

		Map<String, String> m = new HashMap<>();
		m.put("Company", "OL");
		m.put("OL", "1");
		m.put("SS","2");
		m.put("TS","3");
		m.put("CS", "4");

		m.forEach((k,v) -> System.out.println(k+" : "+v));

	}

}
