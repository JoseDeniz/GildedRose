package gilded_rose;

public class GildedRoseItem {

    protected final Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public Integer getQuality() {
        return item.getQuality();
    }

    public void updateQuality() {
        decreaseQuality();
        decreaseSellIn();
    }

    public void decreaseQuality() {
        if (isQualityMoreThanZero(item))
            this.item.setQuality(this.item.getQuality() - 1);
    }

    public void decreaseSellIn() {
        if (!isSellInEqualsOrLessThanZero(item))
            item.setSellIn(item.getSellIn() - 1);
        else decreaseQuality();
    }

    public void increaseQuality() {
        item.setQuality(item.getQuality() + 1);
    }

    protected boolean isQualityLessThanFifty(Item item) {
        return item.getQuality() < 50;
    }

    protected boolean isQualityMoreThanZero(Item item) {
        return item.getQuality() > 0;
    }

    protected boolean isSellInEqualsOrLessThanZero(Item item) {
        return item.getSellIn() <= 0;
    }
}
