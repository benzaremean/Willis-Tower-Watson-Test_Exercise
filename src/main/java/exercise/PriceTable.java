package exercise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class PriceTable {
    private Currency currency;

    private Varieties[] columnNames = new Varieties[]{Varieties.VARIETY1, Varieties.VARIETY2, Varieties.VARIETY3, Varieties.VARIETY4};
    private Product[] rowNames = new Product[]{Product.PRODUCT1, Product.PRODUCT2, Product.PRODUCT3, Product.PRODUCT4};

    private PriceTable(Currency currency) {
        this.currency = currency;
        this.table = this.convert();
    }

    private Double[][] table;

    private final BigDecimal[][] BASE_TABLE = new BigDecimal[][]{
        { new BigDecimal(10), new BigDecimal(12), new BigDecimal(14), new BigDecimal(45) },        
        { new BigDecimal(20), new BigDecimal(15), new BigDecimal(24), new BigDecimal(0) },        
        { new BigDecimal(22), new BigDecimal(60), new BigDecimal(0), new BigDecimal(0) },        
        { new BigDecimal(28), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0) },        
    };

    private Double[][] convert() {
        var baseValueTimesCoefficientTable = new Double[4][4];
        for (int i = 0; i < BASE_TABLE.length; i++) {
            for (int j = 0; j < BASE_TABLE[i].length; j++) {
                baseValueTimesCoefficientTable[i][j] = BASE_TABLE[i][j].multiply(this.currency.getCoefficient()).doubleValue();
            }
        }
        return baseValueTimesCoefficientTable;
    }

    public Double[][] getTable() {
        return this.table;
    }

    public Double getTotalByVariety(Varieties variety) {
        var index = Arrays.asList(this.columnNames).indexOf(variety);
        Double total = 0.0;
        for (int i = 0; i < this.table.length; i++) {
            total += this.table[i][index].doubleValue();
        }
        return total;
    }    
    
    public Double[] getTotal() {
        var list = new ArrayList<Double>();
        for (int i = 0; i < columnNames.length; i++) {
            list.add(getTotalByVariety(columnNames[i]));
        }
        return list.stream().toArray(Double[]::new);
    }

    public void print() {
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s |%n";
        System.out.format("%s%n", this.currency.name() + " TABLE");
        System.out.format(
            leftAlignFormat, 
            "", 
            this.columnNames[0].getDisplayName(), 
            this.columnNames[1].getDisplayName(),
            this.columnNames[2].getDisplayName(),
            this.columnNames[3].getDisplayName()
        );
        for (int i = 0; i < this.table.length; i++) {
            System.out.format(leftAlignFormat, this.rowNames[i].getDisplayName(), this.table[i][0], this.table[i][1], this.table[i][2], this.table[i][3]);
        }
        var total = this.getTotal();
        System.out.format(leftAlignFormat, "TOTAL", total[0], total[1], total[2], total[3]);
        System.out.format("%n");
    }


    static PriceTable create(Currency currency) {
        return new PriceTable(currency); 
    }
}
