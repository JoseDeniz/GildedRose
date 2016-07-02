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
                if (!isAged(item)) {
                    if (!isBackstage(item) && !isSulfuras(item)) {
                        normalItem.updateQuality();
                    } else {
                        normalItem.updateQuality();
                    }
                } else {
                    normalItem.updateQuality();
                }
            }
        }
    }

    private boolean isSellInLessThanZero(Item item) {
        return item.getSellIn() < 0;
    }

    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

    private boolean isAged(Item item) {
        return "Aged Brie".equals(item.getName());
    }

    private boolean isBackstage(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

}