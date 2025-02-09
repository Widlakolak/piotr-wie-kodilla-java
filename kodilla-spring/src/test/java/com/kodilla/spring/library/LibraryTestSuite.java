package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testContext() {
        //Given
        ApplicationContext context =
//                new AnnotationConfigApplicationContext(LibraryConfig.class);
                new AnnotationConfigApplicationContext("com.kodilla.spring");


        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

    @Test
    void testLoadFromDb() {
        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);

        //When
        library.loadFromDb();
    }

    @Test
    void testSaveToDb() {
        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);

        //When
        library.saveToDb();
    }
}
