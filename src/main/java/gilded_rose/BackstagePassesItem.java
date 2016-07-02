package gilded_rose;

public class BackstagePassesItem extends GildedRoseItem {

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (!isSellInEqualsOrLessThanZero(item)) {
            if (isQualityLessThanFifty(item))
                increaseQuality();
            if (isSellInEqualOrLessThanTen(item) && isQualityLessThanFifty(item)) {
                increaseQuality();
            }
            if (isSellInEqualOrLessThanFive(item) && isQualityLessThanFifty(item)) {
                increaseQuality();
            }
            decreaseSellIn();
        } else {
            setQualityToZero(item);
        }
    }

    private boolean isSellInEqualOrLessThanTen(Item item) {
        return item.getSellIn() <= 10;
    }

    private boolean isSellInEqualOrLessThanFive(Item item) {
        return item.getSellIn() <= 5;
    }

    private void setQualityToZero(Item item) {
        item.setQuality(0);
    }
}
