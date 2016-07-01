package gilded_rose;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NormalItemTest {

    private static final String MONGOOSE = "Elixir of the Mongoose";

    @Test
    public void when_we_update_the_day_quality_item_should_be_decreased() {
        NormalItem normalItem = new NormalItem(new Item(MONGOOSE, 5, 7));
        GildedRose gildedRose = new GildedRose(asList(normalItem));

        gildedRose.updateQuality();

        assertThat(normalItem.getQuality(), is(6));
    }

    @Test
    public void when_we_update_the_day_quality_cannot_be_negative() {
        NormalItem normalItem = new NormalItem(new Item(MONGOOSE, 0, 0));
        GildedRose gildedRose = new GildedRose(asList(normalItem));

        gildedRose.updateQuality();

        assertThat(normalItem.getQuality(), is(0));
    }

    @Test public void
    when_whe_update_the_day_and_there_is_no_more_days_left_quality_should_be_decreased_double() {
        NormalItem normalItem = new NormalItem(new Item(MONGOOSE, 0, 8));
        GildedRose gildedRose = new GildedRose(asList(normalItem));

        gildedRose.updateQuality();

        assertThat(normalItem.getQuality(), is(6));
    }
}
