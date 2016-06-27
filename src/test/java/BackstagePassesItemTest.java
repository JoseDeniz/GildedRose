import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackstagePassesItemTest {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    /**
     * <= 0 --> quality = 0
     */

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
    when_whe_update_the_day_and_there_are_more_than_five_and_less_than_ten_quality_should_be_increased_by_two() {
        Item item = new Item(BACKSTAGE_PASSES, 10, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(6));
    }

    @Test
    public void
    when_whe_update_the_day_and_there_are_more_than_zero_less_than_ten_quality_should_be_increased_by_three() {
        Item item = new Item(BACKSTAGE_PASSES, 5, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(7));
    }
}
