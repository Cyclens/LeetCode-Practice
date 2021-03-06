package Google;

import java.util.Iterator;
import java.util.List;

public class Flatten_2D_Vector implements Iterator<Integer> {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Flatten_2D_Vector(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public Integer next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}
