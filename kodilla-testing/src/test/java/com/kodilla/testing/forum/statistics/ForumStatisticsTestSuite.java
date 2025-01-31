package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }


    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testWhenPostsZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(5, "User"));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNumberOfUsers());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(100, forumStatistics.getNumberOfComments());
        assertEquals(0.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(100.0 / 5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWhenPostsOneThousand() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(5, "User"));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(100, forumStatistics.getNumberOfComments());
        assertEquals(1000.0 / 5, forumStatistics.getAveragePostsPerUser());
        assertEquals(100.0 / 5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(100.0 / 1000, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWhenCommentsZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(5, "User"));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNumberOfUsers());
        assertEquals(50, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(50.0 / 5, forumStatistics.getAveragePostsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWhenMoreCommentsThanPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(5, "User"));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNumberOfUsers());
        assertEquals(50, forumStatistics.getNumberOfPosts());
        assertEquals(100, forumStatistics.getNumberOfComments());
        assertEquals(50.0 / 5, forumStatistics.getAveragePostsPerUser());
        assertEquals(100.0 / 5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(100.0 / 50, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWhenMorePostsThanComments() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(5, "User"));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getNumberOfUsers());
        assertEquals(200, forumStatistics.getNumberOfPosts());
        assertEquals(100, forumStatistics.getNumberOfComments());
        assertEquals(200.0 / 5, forumStatistics.getAveragePostsPerUser());
        assertEquals(100.0 / 5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(100.0 / 200, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWhenUsersZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getNumberOfUsers());
        assertEquals(50, forumStatistics.getNumberOfPosts());
        assertEquals(100, forumStatistics.getNumberOfComments());
        assertEquals(0.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(100.0 / 50, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWhenUsersOneHundred() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(100, "User"));
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(50, forumStatistics.getNumberOfPosts());
        assertEquals(100, forumStatistics.getNumberOfComments());
        assertEquals(50.0 / 100, forumStatistics.getAveragePostsPerUser());
        assertEquals(100.0 / 100, forumStatistics.getAverageCommentsPerUser());
        assertEquals(100.0 / 50, forumStatistics.getAverageCommentsPerPost());
    }
}
