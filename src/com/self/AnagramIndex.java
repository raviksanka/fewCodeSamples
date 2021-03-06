package com.self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * This is used to find the index(s) of a particular string in the 
 *      anagram list of the given string.
 */
public class AnagramIndex {

	public static void main(String[] args) {
    	//System.out.println(getAnagramLst("abcd")); - To get list of anagrams of a string
		System.out.println(getIndexOfAnagrams("rabdcbaj", getAnagramLst("abcd")));
	}
	
	public static ArrayList<Integer> getIndexOfAnagrams (String masterStr, List<String> strsToChk) {
		ArrayList<Integer> indexLst = new ArrayList<Integer>();
		Set<Integer> indexSet = new HashSet<Integer>();
		for(String anaStr : strsToChk)
		for (int i = -1; (i = masterStr.indexOf(anaStr, i + 1)) != -1; ) {
			indexSet.add(i);
		}
		indexLst.addAll(indexSet);
		Collections.sort(indexLst);
		return indexLst;
	}
	
	public static ArrayList<String> getAnagramLst(String inputStr) {
	    // The final list
	    ArrayList<String> anagramLst = new ArrayList<String>();
	    // If input string's length is 1, return {inputStr}
	    if (inputStr.length() == 1) {
	    	anagramLst.add(inputStr);
	    } else if (inputStr.length() > 1) {
	        int lastIndex = inputStr.length() - 1;
	        // Get the last character
	        String lastChar = inputStr.substring(lastIndex);
	        // Remaining string
	        String restOfStr = inputStr.substring(0, lastIndex);
	        // Perform permutation on the rest string and merge with the last character
	        anagramLst = merge(getAnagramLst(restOfStr), lastChar);
	    }
	    return anagramLst;
	}
	
	public static ArrayList<String> merge(ArrayList<String> resultLst, String lstChr) {
	    ArrayList<String> res = new ArrayList<String>();
	    // Loop through the entire string in the list
	    for (String s : resultLst) {
	        // For each string, insert the last character to all possible positions and add them to the new list
	        for (int i = 0; i <= s.length(); ++i) {
	            String ps = new StringBuffer(s).insert(i, lstChr).toString();
	            res.add(ps);
	        }
	    }
	    return res;
	}

}
