package poly.manhnd.webapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Endcoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("123");
		System.out.println(encode);
	}
}
