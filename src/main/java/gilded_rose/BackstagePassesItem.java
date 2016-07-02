package gilded_rose;

public class BackstagePassesItem extends NormalItem {

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanFifty(item))
            increaseQuality();
        if (isSellInEqualOrLessThanTen(item) && isQualityLessThanFifty(item)) {
            increaseQuality();
        }

        if (isSellinEqualOrLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQuality();
        }
    }
}
