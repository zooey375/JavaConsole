package case04;

import java.security.MessageDigest;

public class SimplePasswordHash {

	// 產生雜湊
	public static String hashPassword(String password) throws Exception {
	// 使用 SHA-256 雜湊演算法	
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest(password.getBytes());
		// 將 byte[] 轉成 16 進位字串
		StringBuilder sb = new StringBuilder();
		for(byte b : hashBytes) { 
			sb.append(String.format("%02x", b)); // x 是轉成 16 進位字。
			
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String password = "1234";
		String hash = hashPassword(password);
		System.out.printf("password: %s hash: %s%n", password, hash);
		
	}
}
