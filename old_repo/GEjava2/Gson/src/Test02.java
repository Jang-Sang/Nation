import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Test02 {
	
	public static void main(String[] args) {

		Gson gson = new Gson(); // 객체 생성...

		String s1 = gson.toJson(true);
		Boolean b = gson.fromJson(s1, Boolean.class);
		System.out.println(b);
		System.out.println( b instanceof Boolean);

		String s2 = gson.toJson(13);
		int a = gson.fromJson(s2, Integer.class);
		System.out.println(a);

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		String s3 = gson.toJson(arr);
		int[] ar = gson.fromJson(s3, int[].class);
		for(int a1 : ar) {
			System.out.println(a1);
		}
		
		Info in = new Info("김민준", 20, true);
		String s6 = gson.toJson(in);
		in = gson.fromJson(s6, Info.class);
		System.out.println(in.name);
		System.out.println(in.age);
		System.out.println(in.admin);
		
//		List<String> li = new ArrayList<String>();
//		li.add("수박");
//		li.add("망고");
//		li.add("감");
		
		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		
		String s4 = gson.toJson(li);
		
		li = gson.fromJson(s4, List.class); // 숫자는 double로 된다...
		System.out.println(li);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "김민준");
		map.put("age", 20);
		map.put("admin", true);
		String s5 = gson.toJson(map);
		Map m = gson.fromJson(s5, Map.class);
		System.out.println(m.get("name") instanceof String);
		System.out.println(m.get("age") instanceof Double);
		System.out.println(m.get("admin") instanceof Boolean);



	}

}

























































