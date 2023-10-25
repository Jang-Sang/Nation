import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

// Gson을 이용하려면 외부의 라이브러리를 이용하여야 한다...
// Gson 다운 로드...
// - 크롬에서 검색 -> 깃허브 접속 -> Gson jar downloads 클릭 -> 우측 상단 download 클릭 -> jar 클릭후 다운로드

// jar 파일 추가
// - 프로젝트 마우스 오른쪽 버튼 클릭 -> build path -> library 탭 -> add External jar -> 파일위치 찾아서 파일 클릭후 확인
//   -> apply and close 클릭.


public class Test01 {

	public static void main(String[] args) {
		
		//Json 문자열을 만든다거나 , Json 문자열을 토대로 객체를 만들어주는 라이브러리
		Gson gson = new Gson(); // 객체 생성...
		
		String s1 = gson.toJson(true);
		System.out.println(s1);
		
		String s2 = gson.toJson(13);
		System.out.println(s2);
		
		int[] arr = new int[] {1,2,3,4,5};
		String s3 = gson.toJson(arr);
		System.out.println(s3);
		
		List<String> li = new ArrayList<String>();
		li.add("수박");
		li.add("망고");
		li.add("감");
		
		String s4 = gson.toJson(li);
		System.out.println(s4);
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "김민준");
		map.put("age", 20);
		map.put("admin", true);
		
		String s5 = gson.toJson(map);
		System.out.println(s5);
		
		Info in = new Info("김민준", 20, true);
		String s6 = gson.toJson(in);
		System.out.println(s6);
	
	}
	
}

















