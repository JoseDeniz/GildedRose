package gilded_rose;

public class AgedBrieItem extends GildedRoseItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanFifty(item))
            increaseQuality();
    }
}
