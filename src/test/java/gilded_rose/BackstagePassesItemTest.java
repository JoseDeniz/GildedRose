package gilded_rose;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackstagePassesItemTest {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void
    when_whe_update_the_day_and_there_are_more_than_ten_days_left_quality_should_be_increased_by_one() {
        Item item = new Item(BACKSTAGE_PASSES, 20, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(5));
    }

    @Test
    public void
    when_whe_update_the_day_and_there_are_more_than_five_days_and_less_than_ten_days_quality_should_be_increased_by_two() {
        Item item = new Item(BACKSTAGE_PASSES, 10, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(6));
    }

    @Test
    public void
    when_whe_update_the_day_and_there_are_more_days_than_zero_less_days_than_ten_quality_should_be_increased_by_three() {
        Item item = new Item(BACKSTAGE_PASSES, 5, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(7));
    }

    @Test
    public void
    when_whe_update_the_day_and_there_are_less_days_left_than_zero_quality_should_be_zero() {
        Item item = new Item(BACKSTAGE_PASSES, 0, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(0));
    }

    @Test
    public void when_we_update_the_day_quality_cannot_be_more_than_fifty() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES, 3, 50);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(50));
    }
}
