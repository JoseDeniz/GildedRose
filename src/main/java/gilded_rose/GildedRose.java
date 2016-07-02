package gilded_rose;

import java.util.List;

public class GildedRose {

    private List<NormalItem> items;

    public GildedRose(List<NormalItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (NormalItem normalItem : items) {
            Item item = normalItem.getItem();

            normalItem.updateQuality();

            if (!isSulfuras(item)) {
                normalItem.decreaseSellIn();
            }

            if (isSellInLessThanZero(item)) {
                normalItem.updateQuality();
            }
        }
    }

    private boolean isSellInLessThanZero(Item item) {
        return item.getSellIn() < 0;
    }

    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

}