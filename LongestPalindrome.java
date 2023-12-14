package DSA;

import java.util.HashMap;

public class LongestPalindrome {
    public static int getLongestPalindrome(String s){
        HashMap<Character, Integer> input = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (input.containsKey(ch)){
                input.put(ch, input.get(ch)+1);
            }else {
                input.put(ch,1);
            }
        }

        int counter = 0;
        boolean isSingleDigitAdded = false;
        for (int val : input.values()){
            if (val%2 == 0){
                counter += val;
            } else if (val%2 !=0 && val>2){
                if (!isSingleDigitAdded){
                    counter += val;
                    isSingleDigitAdded = true;
                }else {
                    counter += val - 1;
                }
            }else if (!isSingleDigitAdded){
                counter += val;
                isSingleDigitAdded = true;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("a"));
    }
}
