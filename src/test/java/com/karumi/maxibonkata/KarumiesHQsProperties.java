package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class KarumiesHQsProperties {
    private KarumiHQs karumiHQs;

    @Before public void setup() {
        karumiHQs = new KarumiHQs();
    }

    @Property(trials = 1000) public void theNumberOfMaxibonsIsAlwaysBiggerThan2(
            @From(DevelopersGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);

        System.out.println(karumiHQs);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property() public void theNumberOfMaxibonsIsAlwaysBiggerThan2WithSeveralDevelopers(
            List<@From(DevelopersGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);

        System.out.println(karumiHQs);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }
}
