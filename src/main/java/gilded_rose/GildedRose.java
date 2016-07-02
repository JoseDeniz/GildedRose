package gilded_rose;

import java.util.List;

public class GildedRose {

    private List<NormalItem> items;

    public GildedRose(List<NormalItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(NormalItem::updateQuality);
    }

}