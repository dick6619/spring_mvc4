package com.iii.emp.test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ClientPerson {
	// default g
	private BigInteger g = new BigInteger("2");

	// default p
	private BigInteger p = new BigInteger(
			"00:9f:db:8b:8a:00:45:44:f0:04:5f:17:37:d0:ba:2e:0b:27:4c:df:1a:9f:58:82:18:fb:43:53:16:a1:6e:37:41:71:fd:19:d8:d8:f3:7c:39:bf:86:3f:d6:0e:3e:30:06:80:a3:03:0c:6e:4c:37:57:d0:8f:70:e6:aa:87:10:33"
					.replaceAll(":", ""),
			16);

	// user private key
	private BigInteger privateKey;

	// 預設建構式
	public ClientPerson() {
	}

	// 自己設定g,p
	public ClientPerson(String g, String hex) {
		this.g = new BigInteger(g);
		this.p = new BigInteger(hex.replaceAll(":", ""), 16);
	}

	// 求partial key
	public BigInteger getPartialKey(BigInteger privateKey) {
		return g.modPow(privateKey, p);
	}
	public Map<String, Object> getPartialKeyProcessInfo(BigInteger privateKey) {
		long start = System.currentTimeMillis();
		BigInteger partialKey = getPartialKey(privateKey);
		long end = System.currentTimeMillis();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("'key'", partialKey);
		map.put("'cost-time(ms)'", end-start);
		return map;
	}

	// 求full key
	public BigInteger getFullKey(BigInteger partialKey, BigInteger privateKey) {
		return partialKey.modPow(privateKey, p);
	}
	public Map<String, Object> getFullKeyProcessInfo(BigInteger partialKey, BigInteger privateKey) {
		long start = System.currentTimeMillis();
		BigInteger fullKey = getFullKey(partialKey, privateKey);
		long end = System.currentTimeMillis();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("'key'", fullKey);
		map.put("'cost-time(ms)'", end-start);
		return map;
	}

	// 設定private key
	void setPrivateKey(String key) {
		this.privateKey = new BigInteger(key, 16);
	}

	// get
	BigInteger getPrivateKey() {
		return this.privateKey;
	}
	// main 測試
	public static void main(String[] args) {

		// Alice
		ClientPerson alice = new ClientPerson();
		alice.setPrivateKey("009fdb8b8a004544");
		BigInteger aliceToBob = alice.getPartialKey(alice.getPrivateKey());
		System.out.println("a=" + aliceToBob); // 給Bob的

		// Bob
		ClientPerson bob = new ClientPerson();
		bob.setPrivateKey("f0045f1737d0");
		BigInteger bobToAlice = bob.getPartialKey(bob.getPrivateKey());
		System.out.println("b=" + bobToAlice); // Alice的

		System.out.println("Alice fullKey = " + alice.getFullKey(bobToAlice, alice.getPrivateKey()));
		System.out.println("Bob   fullKey = " + bob.getFullKey(aliceToBob, bob.getPrivateKey()));

		System.out.println("(A, TA)= " + alice.getPartialKeyProcessInfo(alice.getPrivateKey()));
		System.out.println("(B, TB)= " + bob.getPartialKeyProcessInfo(bob.getPrivateKey()));
		System.out.println("(KA TKA) = " + alice.getFullKeyProcessInfo(bobToAlice, alice.getPrivateKey()));
		System.out.println("(KB TKB) = " + alice.getFullKeyProcessInfo(aliceToBob, bob.getPrivateKey()));
	}
}
