import java.security.MessageDigest;

public class CodingUtil {

	// 加密
	public static String applySha256(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
            //
			byte[] hash = md.digest(input.getBytes("UTF-8"));

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				//  11111111 
				//&   hash[i]
				//-------------
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
