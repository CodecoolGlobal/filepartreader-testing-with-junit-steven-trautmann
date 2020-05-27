package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    static FilePartReader reader = new FilePartReader();

    @BeforeAll
    static void setupAndTest() {
        assertDoesNotThrow(() -> reader.setup("./src/test/resources/read_this.txt", 1, 6));
    }

    @Test
    void readTest() throws IOException {
        assertDoesNotThrow(() -> reader.read());
        String content = reader.read();
        assertEquals("kik\nfaszom\nkivan\nmár", content);
    }

    @Test
    void readLinesTest() throws IOException {
        String contentLines = reader.readLines();
        assertDoesNotThrow(() -> reader.readLines());
        assertEquals("kik\nfaszom\nkivan\nmár", contentLines);
    }
}