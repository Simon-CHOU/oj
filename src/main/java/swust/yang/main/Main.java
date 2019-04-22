package swust.yang.main;

import java.util.Map;

import swust.yang.util.ResultsSummar;

public class Main {

	public static void main(String[] args) {
		ResultsSummar.init();
		Map<String, Integer> map = ResultsSummar.getMap();
		map.put("test", 11);
		System.out.println("map size:" + ResultsSummar.getMap().size());
		System.out.println("map contains key:" + ResultsSummar.getMap().containsKey("test"));
		ResultsSummar.clear();
		System.out.println("map clear:" + ResultsSummar.getMap().isEmpty());
	}

}
