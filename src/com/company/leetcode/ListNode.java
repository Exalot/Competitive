package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/add-two-numbers/description/
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abb";
        System.out.println(sol.longestPalindrome(s));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode result = new ListNode();
        int index = 0;
        boolean carry = false;
        while (currentNode1 != null || currentNode2 != null || carry) {
            int currentNum = 0;
            if (currentNode1 != null) {
                currentNum += currentNode1.val;
                currentNode1 = currentNode1.next;
            }
            if (currentNode2 != null) {
                currentNum += currentNode2.val;
                currentNode2 = currentNode2.next;
            }
            if (carry) {
                currentNum += 1;
                carry = false;
            }
            if (currentNum >= 10) {
                carry = true;
                currentNum = currentNum % 10;
            }
            ListNode currentNode = result;
            if (index != 0) {
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                currentNode.next = new ListNode(currentNum);
            } else {
                currentNode.val = currentNum;
            }
            System.out.println(index + " " + currentNum);
            index++;
        }
        return result;
    }

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        int largestLen = 0;
        if (s.length() > 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i; j < s.length(); j++) {
                    largestLen = Math.max(largestLen, subStringStarting(s, j));
                }
            }
        } else {
            return s.length();
        }
        return largestLen;
    }

    public int subStringStarting(String s, int index) {
        String subString = "";
        for (int i = index; i < s.length(); i++) {
            if (subString.contains(s.substring(i, i + 1))) {
                return subString.length();
            } else {
                subString += s.substring(i, i + 1);
            }
        }
        return subString.length();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index;
        boolean finished1 = false;
        boolean finished2 = false;
        if (nums1.length != 0 && nums2.length != 0) {
            for (int k = 0; k < result.length; k++) {
                index = i + j;
                if (finished1)
                    index++;
                if (finished2)
                    index++;
                if ((nums1[i] <= nums2[j] && !finished1) || finished2) {
                    result[index] = nums1[i];
                    if (i == nums1.length - 1) {
                        finished1 = true;
                    } else {
                        i++;
                    }
                } else if ((nums2[j] <= nums1[i] && !finished2) || finished1) {
                    result[index] = nums2[j];
                    if (j == nums2.length - 1) {
                        finished2 = true;
                    } else {
                        j++;
                    }
                }
                //System.out.println(Arrays.toString(result));
            }
        } else if (nums1.length == 0) {
            result = nums2;
        } else {
            result = nums1;
        }
        if (result.length % 2 == 1) {
            return result[result.length / 2];
        } else {
            return ((double) result[result.length / 2] + (double) result[result.length / 2 - 1]) / 2;
        }
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.substring(0,1);
        }
        String oddProcessed = oddProcessing(s, 0);
        for (int i = 0; i < s.length(); i++) {
            String longPaliOdd = oddProcessing(s, i);
            if (longPaliOdd.length() > oddProcessed.length()) {
                oddProcessed = longPaliOdd;
            }
        }
        String evenProcessed = evenProcessing(s, 0);
        for (int i = 0; i < s.length() - 1; i++) {
            String longEvenProcessed = evenProcessing(s, i);
            if (longEvenProcessed.length() > evenProcessed.length()) {
                evenProcessed = longEvenProcessed;
            }
        }
        if (oddProcessed.length() > evenProcessed.length()) {
            return oddProcessed;
        } else {
            return evenProcessed;
        }
    }

    public String oddProcessing(String s, int index) {
        int increment = 0;
        boolean done = false;
        while (!done) {
            if (s.charAt(index - increment) != s.charAt(index + increment)) {
                done = true;
                increment--;
            } else {
                if (index - increment - 1 >= 0 && index + increment + 1 < s.length()) {
                    increment++;
                } else {
                    done = true;
                }
            }
        }
        return s.substring(index-increment, index+increment+1);

    }

    public String evenProcessing(String s, int index) {
        int increment = 0;
        boolean done = false;
        while (!done) {
            if (s.charAt(index - increment) != s.charAt(index + increment + 1)) {
                increment--;
                done = true;
            } else {
                if (index - increment - 1 >= 0 && index + increment + 2 < s.length()) {
                    increment++;
                } else {
                    done = true;
                }
            }
        }
        return s.substring(index - increment, index + increment + 2);
    }
}
