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

    protected void decreaseQuality() {
        if (isQualityMoreThanZero())
            this.item.setQuality(this.item.getQuality() - 1);
    }

    protected void decreaseSellIn() {
        if (!isSellInEqualsOrLessThanZero())
            item.setSellIn(item.getSellIn() - 1);
        else decreaseQuality();
    }

    protected void increaseQuality() {
        if (isQualityLessThanFifty())
            item.setQuality(item.getQuality() + 1);
    }

    protected boolean isQualityLessThanFifty() {
        return item.getQuality() < 50;
    }

    protected boolean isQualityMoreThanZero() {
        return item.getQuality() > 0;
    }

    protected boolean isSellInEqualsOrLessThanZero() {
        return item.getSellIn() <= 0;
    }
}
