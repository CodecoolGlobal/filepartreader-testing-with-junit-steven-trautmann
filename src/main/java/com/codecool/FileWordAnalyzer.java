package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader){
        this.reader = reader;
    }

    public List getWordsOrderedAlphabetically() throws IOException {
        String contentLines = reader.readLines();
        ArrayList<String> alphabetSort = new ArrayList<>(Arrays.asList(contentLines.split("\n")));
        Collections.sort(alphabetSort);
        return alphabetSort;
    }

    public List getWordsContainingSubstring (String subString) throws IOException {
        String contentLines = reader.readLines();
        ArrayList<String> subStringSort = new ArrayList<>(Arrays.asList(contentLines.split("\n")));
        subStringSort.removeIf(s -> !s.toLowerCase().contains(subString));
        return subStringSort;
    }

    public List getStringsWhichPalindromes () throws IOException {
        String contentLines = reader.readLines();
        ArrayList<String> palindromes = new ArrayList<>(Arrays.asList(contentLines.split("\n")));
        palindromes.removeIf(s -> !isItPalindrome(s));
        return palindromes;
    }

    public boolean isItPalindrome(String str){
        str = str.toLowerCase();
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
