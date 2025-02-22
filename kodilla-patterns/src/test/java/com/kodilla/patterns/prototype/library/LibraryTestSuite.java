package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library library = new Library("My Library");

        IntStream.rangeClosed(1, 10).forEach(n -> {
            String title = "Book #" + n;
            String author = "Author #" + (n % 3 + 1);
            LocalDate date = LocalDate.now().minusYears(n).withDayOfMonth(1);
            library.getBooks().add(new Book(title, author, date));
        });

        Library shallowCopy = library.shallowCopy();
        shallowCopy.setName("Shallow Copy");

        Library deepCopy = library.deepCopy();
        deepCopy.setName("Deep Copy");

        // When
        library.getBooks().removeIf(book -> book.getTitle().endsWith("5"));

        // Then
        System.out.println(library);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);

        assertEquals(9, library.getBooks().size());
        assertEquals(9, shallowCopy.getBooks().size());
        assertEquals(10, deepCopy.getBooks().size());
    }
}
