import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackstagePassesItemTest {

    /**
     * <= 10 && >= 5 --> quality += 2
     * <= 5 > 0 --> quality += 3
     * <= 0 --> quality = 0
     */

    @Test public void
    when_whe_update_the_day_and_there_are_more_than_ten_days_left_quality_should_be_increased_by_one() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 4);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getQuality(), is(5));
    }

}
