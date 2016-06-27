import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SulfurasItemTest {

    private String SULFURAS = "Sulfuras, Hand of Ragnaros";

	@Test
	public void when_we_update_the_day_sulfuras_quality_should_not_change() {
        Item item = new Item(SULFURAS, 0, 80);
        GildedRose gildedRose = new GildedRose(asList(item));

        gildedRose.updateQuality();

        assertThat(item.getSellIn(),is(0));
        assertThat(item.getQuality(),is(80));
    }

}
