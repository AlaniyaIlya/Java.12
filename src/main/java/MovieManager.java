public class MovieManager {
    private PosterMovie[] items = new PosterMovie[0];

    public void save(PosterMovie item) {
        PosterMovie[] tmp = new PosterMovie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PosterMovie[] findAll() {
        return items;
    }

    public PosterMovie[] findLastDef() {
        PosterMovie[] all = items;
        int resultLength;
        if (items.length > 10) {
            resultLength = 10;
        } else {
            resultLength = items.length;
        }
        PosterMovie[] last = new PosterMovie[resultLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = all[all.length - 1 - i];
        }
        return last;
    }

    public PosterMovie[] findLast(int num) {
        PosterMovie[] all = items;
        int resultLength;
        if (items.length < num) {
            resultLength = items.length;
        } else {
            resultLength = num;
        }
        PosterMovie[] last = new PosterMovie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            last[i] = all[all.length - 1 - i];
        }
        return last;
    }


}