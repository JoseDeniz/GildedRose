import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NormalItemTest {

    private static final int SELL_IN = 5;
    private static final int QUALITY = 7;
    private static final String MONGOOSE = "Elixir of the Mongoose";

    @Test
    public void When_we_update_the_day_quality_item_should_be_decreased() {
        Item item = new Item(MONGOOSE, SELL_IN, QUALITY);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(6));
    }
}
