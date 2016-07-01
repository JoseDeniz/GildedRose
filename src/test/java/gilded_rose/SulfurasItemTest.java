package gilded_rose;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SulfurasItemTest {

    private static final int SELL_IN = 0;
    private static final int QUALITY = 80;
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    public void when_we_update_the_day_quality_should_not_change() {
        SulfurasItem sulfurasItem = new SulfurasItem(new Item(SULFURAS, SELL_IN, QUALITY));
        GildedRose gildedRose = new GildedRose(asList(sulfurasItem));

        gildedRose.updateQuality();

        assertThat(sulfurasItem.getQuality(), is(80));
    }

}
