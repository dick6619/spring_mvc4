import java.util.Date;
public class Block {
	public String preHash;
	public Long time;
	public String messeges;
	// 隨機數
	public int nonce;
	// 算出來後的
	public String hash;

	public Block(String messeges, String preHash) {
		this.messeges = messeges;
		this.preHash = preHash;
		this.time = new Date().getTime();
		this.hash = calculateHash();
	}

	// 1. 鏈上區塊前需要算一個字符串(前一個區塊的hash + 交易的訊息 + 時間戳記 + 一個隨機數)
	// 2. 將第一點，做兩次sha256運算 sha256(sha256(字符串))
	// 3. 算出來256位數， 要求前n位要是0，前面的n越多就越難算
	// 4. 其他動三樣都是固定的，能動的就是隨機數，所以要一個一個嘗試隨機數，直到符合前位n個0
	// 5. 每個人計算時的題目的難度都是不一樣的，因為頭部相同外，每個人打包的帳單不同，個人訊息，時間也是不一樣的
	public String calculateHash() {
		String calculatedhash = CodingUtil
				.applySha256(preHash + Long.toString(time) + Integer.toString(nonce) + messeges);
		return calculatedhash;
	}

	// 難度，前面多少個0
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
		while (!hash.substring(0, difficulty).equals(target)) {
			// 隨機數一個一個try
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
