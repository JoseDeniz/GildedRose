package gilded_rose;

public class NormalItem {

    private final Item item;

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
}