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
            if (!isAged(item) && !isBackstage(item) && isQualityMoreThanZero(item) && !isSulfuras(item)) {
                normalItem.decreaseQuality();
            } else {
                if (isQualityLessThanFifty(item)) {
                    normalItem.increaseQuality();
                    updateBackstageQuality(normalItem);
                }
            }

            if (!isSulfuras(item)) {
                normalItem.decreaseSellIn();
            }

            if (isSellInLessThanZero(item)) {
                if (!isAged(item)) {
                    if (!isBackstage(item) && isQualityMoreThanZero(item) && !isSulfuras(item)) {
                        normalItem.decreaseQuality();
                    } else {
                        setQualityToZero(item);
                    }
                } else {
                    if (isQualityLessThanFifty(item)) {
                        normalItem.increaseQuality();
                    }
                }
            }
        }
    }

    private void updateBackstageQuality(NormalItem normalItem) {
        Item item = normalItem.getItem();
        if (isBackstage(item)) {
            if (isSellInEqualOrLessThanTen(item) && isQualityLessThanFifty(item)) {
                normalItem.increaseQuality();
            }

            if (isSellinEqualOrLessThanFive(item) && isQualityLessThanFifty(item)) {
                normalItem.increaseQuality();
            }
        }
    }

    private void setQualityToZero(Item item) {
        item.setQuality(0);
    }

    private boolean isSellInEqualOrLessThanTen(Item item) {
        return item.getSellIn() <= 10;
    }

    private boolean isSellinEqualOrLessThanFive(Item item) {
        return item.getSellIn() <= 5;
    }

    private boolean isSellInLessThanZero(Item item) {
        return item.getSellIn() < 0;
    }

    private boolean isQualityLessThanFifty(Item item) {
        return item.getQuality() < 50;
    }

    private boolean isQualityMoreThanZero(Item item) {
        return item.getQuality() > 0;
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