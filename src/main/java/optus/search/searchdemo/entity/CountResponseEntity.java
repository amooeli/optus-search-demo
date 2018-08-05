package optus.search.searchdemo.entity;

import java.util.HashMap;
import java.util.Map;

public class CountResponseEntity {

    private Map<String, Long> counts = new HashMap<>();

    public Map<String, Long> getCounts() {
        return counts;
    }

    public void setCounts(Map<String, Long> counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CountResponseEntity{");
        sb.append("counts=").append(counts);
        sb.append('}');
        return sb.toString();
    }
}
