package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("John");
        User yGen = new YGeneration("Alice");
        User zGen = new ZGeneration("Bob");

        // When
        String millenialShare = millenial.sharePost();
        String yGenShare = yGen.sharePost();
        String zGenShare = zGen.sharePost();

        // Then
        assertEquals("Facebook", millenialShare);
        assertEquals("Twitter", yGenShare);
        assertEquals("Snapchat", zGenShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        // Given
        User user = new Millenials("Emily");
        String initialShare = user.sharePost();

        // When
        user.setSocialPublisher(new SnapchatPublisher());
        String changedShare = user.sharePost();

        // Then
        assertEquals("Facebook", initialShare);
        assertEquals("Snapchat", changedShare);
    }
}