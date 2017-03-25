package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {

    public static final String ANY_NAME = "Pedro";

    @Property public void theNumberOfMaxibonsAssignedIsPositiveOrZero(int numbberOfMaxibons) {
        Developer developer = new Developer(ANY_NAME, numbberOfMaxibons);
        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }
}
