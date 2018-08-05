package optus.search.searchdemo.service;

import java.util.*;
import java.util.stream.Collectors;

import optus.search.searchdemo.entity.CountResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TextCounterImpl implements TextCounter {

    private static final Logger logger = LoggerFactory.getLogger(TextCounterImpl.class);

    @Override
    public CountResponseEntity findWordsCount(List<String> searchTexts, List<String> source) {
        logger.debug("in findWordsCount method...");
        Objects.requireNonNull(searchTexts, "Search text cannot be null");
        Objects.requireNonNull(source, "Source cannot be null");
        CountResponseEntity countResponseEntity = new CountResponseEntity();
        source.forEach(l -> {
            searchTexts.forEach(s -> {
                int cnt = StringUtils.countOccurrencesOf(l, s.toLowerCase());

                Long val = Long.valueOf(cnt);
                if(countResponseEntity.getCounts().containsKey(s)) {
                    val = Long.valueOf(countResponseEntity.getCounts().get(s).intValue() + cnt);
                }
                countResponseEntity.getCounts().put(s, val);
            });
        });
        return countResponseEntity;
    }

    @Override
    public String findWordsTopCount(int topCount, List<String> source) {
        logger.debug("in findWordsTopCount...");
        Objects.requireNonNull(source, "Source cannot be null");

        if (topCount < 1) {
            return "";
        }

        CountResponseEntity countResponseEntity = new CountResponseEntity();
        source.forEach(l -> {

            Arrays.stream(l.replaceAll("[,.;]", "").split(" ")).forEach(word -> {
                Long val = 1L;
                if (countResponseEntity.getCounts().containsKey(word)) {
                    val = countResponseEntity.getCounts().get(word) + 1;
                }
                countResponseEntity.getCounts().put(word, val);
            });
        });

        List<Map.Entry<String, Long>> result = countResponseEntity.getCounts().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topCount)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        result.forEach(r -> {
            sb.append(r.getKey()).append("|").append(r.getValue()).append(",");
        });
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
