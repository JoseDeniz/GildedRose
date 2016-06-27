import java.util.List;

public class GildedRose {

    private List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            if ((!isAged(i)) && !isBackstage(i)) {
                if (items.get(i).getQuality() > 0) {
                    if (!isSulfuras(i)) {
                        decreaseQuality(i);
                    }
                }
            } else {
                if (items.get(i).getQuality() < 50) {
                    increaseQuality(i);

                    if (isBackstage(i)) {
                        if (items.get(i).getSellIn() < 11) {
                            if (items.get(i).getQuality() < 50) {
                                increaseQuality(i);
                            }
                        }

                        if (items.get(i).getSellIn() < 6) {
                            if (items.get(i).getQuality() < 50) {
                                increaseQuality(i);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(i)) {
                decreaseSellIn(i);
            }

            if (items.get(i).getSellIn() < 0) {
                if (!isAged(i)) {
                    if (!isBackstage(i)) {
                        if (items.get(i).getQuality() > 0) {
                            if (!isSulfuras(i)) {
                                decreaseQuality(i);
                            }
                        }
                    } else {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                } else {
                    if (items.get(i).getQuality() < 50) {
                        increaseQuality(i);
                    }
                }
            }
        }
    }

    private boolean isSulfuras(int i) {
        return "Sulfuras, Hand of Ragnaros".equals(items.get(i).getName());
    }

    private boolean isAged(int i) {
        return "Aged Brie".equals(items.get(i).getName());
    }

    private boolean isBackstage(int i) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName());
    }

    private void decreaseSellIn(int i) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
    }

    private void increaseQuality(int i) {
        items.get(i).setQuality(items.get(i).getQuality() + 1);
    }

    private void decreaseQuality(int i) {
        items.get(i).setQuality(items.get(i).getQuality() - 1);
    }
}