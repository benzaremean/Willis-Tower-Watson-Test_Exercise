package exercise;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class PriceTableTest {

    @Test(expected = NullPointerException.class)
    public void creatingTableWithoutCurrencyShouldThrowNullPointerException() {
        var table = PriceTable.create(null);
    }

    @Test
    public void gbpPricingTableShouldReturnExpectedValues(){
        var gbpPriceTable = PriceTable.create(Currency.GBP);
        var expected = new Double[][]{
            { 10.0, 12.0, 14.0, 45.0 },        
            { 20.0, 15.0, 24.0, 0.0 },        
            { 22.0, 60.0, 0.0, 0.0 },        
            { 28.0, 0.0, 0.0, 0.0 },        
        };
        gbpPriceTable.print();
        assertTrue(Arrays.deepEquals(gbpPriceTable.getTable(), expected));
    }
    
    @Test
    public void getTotalByVarietyShouldReturnTotalsForRelevantColumnGbp(){
        var poundPriceTable = PriceTable.create(Currency.GBP);
        Double expectedTotal = 87.0;
        var actualTotal = poundPriceTable.getTotalByVariety(Varieties.VARIETY2);
        assertEquals(expectedTotal, actualTotal);
    }
    
    @Test
    public void getTotalShouldReturnTotalForAllVarietiesGbp(){
        var poundPriceTable = PriceTable.create(Currency.GBP);
        Double[] expectedTotal = new Double[]{ 80.0, 87.0, 38.0, 45.0 };
        var actualTotal = poundPriceTable.getTotal();
        assertTrue(Arrays.equals(expectedTotal, actualTotal));
    }


    @Test
    public void euroPricingTableShouldReturnExpectedValues(){
        var euroPriceTable = PriceTable.create(Currency.EUR);

        var expected = new Double[][]{
            { 15.0, 18.0, 21.0, 67.5 },        
            { 30.0, 22.5, 36.0, 0.0 },        
            { 33.0, 90.0, 0.0, 0.0 },        
            { 42.0, 0.0, 0.0, 0.0 },        
        };
        euroPriceTable.print();
        assertTrue(Arrays.deepEquals(euroPriceTable.getTable(), expected));
    }

    @Test
    public void getTotalShouldReturnTotalForAllVarietiesEuro(){
        var euroPriceTable = PriceTable.create(Currency.EUR);
        Double[] expectedTotal = new Double[]{ 120.0, 130.5, 57.0, 67.5 };
        var actualTotal = euroPriceTable.getTotal();
        assertTrue(Arrays.equals(expectedTotal, actualTotal));
    }
}