package gilded_rose;

public class NormalItem {

    protected final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuality() {
        return item.getQuality();
    }

    public void decreaseQuality() {
        this.item.setQuality(this.item.getQuality() - 1);
    }

    public void decreaseSellIn() {
        item.setSellIn(item.getSellIn() - 1);
    }

    public void increaseQuality() {
        item.setQuality(item.getQuality() + 1);
    }

    public void updateQuality() {
        if (isQualityMoreThanZero(item))
            decreaseQuality();
    }

    protected boolean isQualityLessThanFifty(Item item) {
        return item.getQuality() < 50;
    }

    protected boolean isQualityMoreThanZero(Item item) {
        return item.getQuality() > 0;
    }

}
