package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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

    @Property() public void ifThereIsLessThanTwoMaxibonsAMessageOfChatIsSent(
            @From(HungryDevelopersGenerator.class) Developer developer) {
        Chat chat = mock(Chat.class);
        KarumiHQs karumiHQs = new KarumiHQs(chat);
        karumiHQs.openFridge(developer);

        System.out.println(karumiHQs);
        verify(chat).sendMessage(any());
    }

    @Property() public void ifThereIsMoreThanTwoMaxibonsAMessageOfChatIsNeverSent(
            @From(NotSoHungryDevelopersGenerator.class) Developer developer) {
        Chat chat = mock(Chat.class);
        KarumiHQs karumiHQs = new KarumiHQs(chat);
        karumiHQs.openFridge(developer);

        System.out.println(karumiHQs);
        verify(chat,never()).sendMessage(any());
    }

}
