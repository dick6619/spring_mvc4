package com.iii.emp.test;

import java.util.HashMap;

public class LeecodeTest {
	// 1. two sum ================================
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			result[0] = i;
			for (int j = i + 1; j < nums.length; j++) {
				if ((target - nums[i] - nums[j]) == 0) {
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer requireNum = target - nums[i];
			if (indexMap.containsKey(requireNum)) {
				int[] result = { indexMap.get(requireNum), i };
				return result;
			} else {
				indexMap.put(nums[i], i);
			}
		}
		return null;
	}

	// 2. addTwoNumbers

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int l1digit = 0;
		int l2digit = 0;
		// l1 value
		for (int i = 0;; i++) {
			l1digit += l1.val * (int) Math.pow(10, i);
			l1 = l1.next;
			if (l1 == null)
				break;
		}
		// l2 value
		for (int i = 0;; i++) {
			l2digit += l2.val * (int) Math.pow(10, i);

			l2 = l2.next;
			if (l2 == null)
				break;
		}
		// l1 + l2
		int digit = l1digit + l2digit;
		//
		ListNode result = new ListNode();
		ListNode pointer = result;

		//
		while (true) {
			int q = digit % 10;
			digit = digit / 10;

			ListNode node = new ListNode(q);
			pointer.next = node;
			pointer = pointer.next;

			if (digit == 0)
				break;
		}

		return result.next;
	}

	// 2. addTwoNumbers

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		return null;
	}

	public int sliceWindow(int[] n, int k) {

		int sum = 0;
		int len = n.length;

		for (int i = 0; i < (len - k) + 1; i++) { //
			int current = 0;
			for (int j = 0; j < k; j++) { //
				current += n[j + i];
			}
			sum = Math.max(current, sum);
		}
		return sum;
	}

	public int lengthOfLongestSubstring(String s) {

		int max = 0;
		int len = s.length();
		for (int k = len; k > 0; k--) {
//			System.out.print("window size=" + k + " ");
			for (int i = 0; i < (len - k) + 1; i++) { //
//				System.out.print("slice count=" + (i + 1) + " ");
				for (int j = 0; j < k; j++) { //
//					System.out.println(s.charAt(i + j));
					// 這邊判斷沒有重複就可以return k;
					//
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LeecodeTest t = new LeecodeTest();
		String s = "pwwkew";
		s = "abcabcbb";
//		s = "bbbbb";
		int[] case1 = { 200, 300, 400 };
		System.out.println(t.lengthOfLongestSubstring(s));
		System.out.println(t.sliceWindow(case1, 2));

	}

}
