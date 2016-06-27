import java.util.List;

public class GildedRose {

    private List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            if ((!isAged(i)) && !isBackstage(i)) {
                if (isQualityMoreThanZero(i)) {
                    if (!isSulfuras(i)) {
                        decreaseQuality(i);
                    }
                }
            } else {
                if (isQualityLessThanFifty(i)) {
                    increaseQuality(i);
                    updateBackstageQuality(i);
                }
            }

            if (!isSulfuras(i)) {
                decreaseSellIn(i);
            }

            if (isSellInLessThanZero(i)) {
                if (!isAged(i)) {
                    if (!isBackstage(i)) {
                        if (isQualityMoreThanZero(i)) {
                            if (!isSulfuras(i)) {
                                decreaseQuality(i);
                            }
                        }
                    } else {
                        decreasedQualityDouble(i);
                    }
                } else {
                    if (isQualityLessThanFifty(i)) {
                        increaseQuality(i);
                    }
                }
            }
        }
    }

    private void updateBackstageQuality(int i) {
        if (isBackstage(i)) {
            if (isSellInEqualOrLessThanTen(i)) {
                if (isQualityLessThanFifty(i)) {
                    increaseQuality(i);
                }
            }

            if (isSellinEqualOrLessThanFive(i)) {
                if (isQualityLessThanFifty(i)) {
                    increaseQuality(i);
                }
            }
        }
    }

    private void decreasedQualityDouble(int i) {
        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
    }

    private boolean isSellInEqualOrLessThanTen(int i) {
        return items.get(i).getSellIn() <= 10;
    }

    private boolean isSellinEqualOrLessThanFive(int i) {
        return items.get(i).getSellIn() <= 5;
    }

    private boolean isSellInLessThanZero(int i) {
        return items.get(i).getSellIn() < 0;
    }

    private boolean isQualityLessThanFifty(int i) {
        return items.get(i).getQuality() < 50;
    }

    private boolean isQualityMoreThanZero(int i) {
        return items.get(i).getQuality() > 0;
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