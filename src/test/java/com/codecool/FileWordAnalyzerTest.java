package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest extends FilePartReaderTest{

    static FileWordAnalyzer fileWordAnalyzer;

    @BeforeAll
    static void setup(){
        fileWordAnalyzer = new FileWordAnalyzer(reader);
    }

    @Test
    void getWordsOrderedAlphabeticallyTest() throws IOException {
        ArrayList<String> alphabeticallyOrdered = (ArrayList<String>) fileWordAnalyzer.getWordsOrderedAlphabetically();
        assertEquals( new ArrayList<String>(Arrays.asList("faszom", "kik", "kivan", "már")), alphabeticallyOrdered);
    }

    @Test
    void getWordsContainingSubstringTest() throws IOException {
        ArrayList<String> containsSubstring = (ArrayList<String>) fileWordAnalyzer.getWordsContainingSubstring("ki");
        assertEquals(new ArrayList<String>(Arrays.asList("kik", "kivan")), containsSubstring);
    }

    @Test
    void getStringsWhichPalindromesTest() throws IOException {
        ArrayList<String> palindromes = (ArrayList<String>) fileWordAnalyzer.getStringsWhichPalindromes();
        assertEquals(new ArrayList<String>(Arrays.asList("kik")), palindromes);
    }
}