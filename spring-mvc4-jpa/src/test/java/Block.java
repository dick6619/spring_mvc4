import java.util.Date;

import com.google.gson.Gson;

public class Block {

	//
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

	// 接塊前需要算一個字符串(目前已有的這個塊，也就是前塊的hash，交易的訊息，時間戳記，最重要的會有一個隨機數)
	// 做兩次sha256運算 sha256(sha256(字符串))
	// 算出來256位數， 要求前n位要是0，前面的n越多就越難算
	// 其他動不了的能動的就是隨機數，所以要一個一個試隨機數，直到算到要求的n個0
	// 每個人計算時的題目的難度都是不一樣的，因為頭部相同外，每個人打包的帳單不同，個人訊息，時間也是不一樣的
	// 總體平均誰的計算能力更強誰就更有機會打包
	// 難度的設置這n是這麼確定的?，1/2^n
	// 比特幣要求10分鐘一個塊
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
