package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    public void testReadFileWithName() {
        // given
        FileReader fileReader = new FileReader();

        // when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }

//    @Test
//    void whenFileDosentExistsReadFileShouldThrowException() {
//        // given
//        FileReader fileReader = new FileReader();
//        String fileName = "nie_ma_takiego_pliku.txt";
//        // when & then
//        assertThrows(FileReaderException.class, () -> fileNameReader.readFile(fileName));
//    }
//
//    @Test
//    void testReadFileName() {
//        //Given
//        FileReader fileReader = new FileReader();
//        String fileName = "names.txt";
//        //When & Then
//        assertDoesNotThrow(() -> fileNameReader.readFile(fileName));
//    }
//
//    @Test
//    void testReadFile() {
//        //Given
//        FileReader fileReader = new FileReader();
//        //When & Then
//        assertDoesNotThrow(() -> fileReader.readFile());
//    }
}
