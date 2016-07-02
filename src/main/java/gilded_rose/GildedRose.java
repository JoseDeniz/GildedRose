package gilded_rose;

import java.util.List;

public class GildedRose {

    private List<GildedRoseItem> items;

    public GildedRose(List<GildedRoseItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(GildedRoseItem::updateQuality);
    }

}