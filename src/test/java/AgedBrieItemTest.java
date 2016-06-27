import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedBrieItemTest {
    private static final int SELL_IN = 2;
    private static final int QUALITY = 0;
    private static final String AGED_BRIE = "Aged Brie";

    @Test
    public void when_whe_update_the_day_quality_should_be_increased() throws Exception {
        Item item = new Item(AGED_BRIE, SELL_IN, QUALITY);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(1));
    }
}
