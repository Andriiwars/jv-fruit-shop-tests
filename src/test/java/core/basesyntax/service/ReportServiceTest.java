package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.storage.Storage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportServiceTest {
    private static ReportService reportService;

    @BeforeClass
    public static void beforeClass() {
        reportService = new ReportServiceImpl();
    }

    @Before
    public void setUp() {
        Storage.storage.put(new Fruit("banana"), 50);
        Storage.storage.put(new Fruit("apple"), 75);
        Storage.storage.put(new Fruit("mango"), 0);
    }

    @Test
    public void getReport_isOk() {
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,50"
                + System.lineSeparator()
                + "apple,75"
                + System.lineSeparator()
                + "mango,0"
                + System.lineSeparator();
        String actual = reportService.makeReport();
        assertEquals(expected, actual);
    }
}