package case02;

import java.util.ArrayList;
import java.util.List;

public class GuestbookMain {
	
	private static List<Guestbook> guestbooks = new ArrayList<>(); // 存放所有留言
	
	public static void main(String[] args) {
		// 留言 1
		Guestbook g1 = new Guestbook("Hello 大家好");
		guestbooks.add(g1); // 存入留言
		System.out.println(guestbooks);
		
		// 留言 2
		Guestbook g2 = new Guestbook("好像快要下雨了...");
		guestbooks.add(g2); // 存入留言
		System.out.println(guestbooks);
		

	}

}
