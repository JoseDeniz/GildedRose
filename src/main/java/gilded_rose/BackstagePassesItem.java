package gilded_rose;

public class BackstagePassesItem extends GildedRoseItem {

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (!isSellInEqualsOrLessThanZero()) {
            if (isQualityLessThanFifty())
                increaseQuality();
            if (isSellInEqualOrLessThanTen() && isQualityLessThanFifty()) {
                increaseQuality();
            }
            if (isSellInEqualOrLessThanFive() && isQualityLessThanFifty()) {
                increaseQuality();
            }
            decreaseSellIn();
        } else {
            setQualityToZero();
        }
    }

    private boolean isSellInEqualOrLessThanTen() {
        return item.getSellIn() <= 10;
    }

    private boolean isSellInEqualOrLessThanFive() {
        return item.getSellIn() <= 5;
    }

    private void setQualityToZero() {
        item.setQuality(0);
    }
}
