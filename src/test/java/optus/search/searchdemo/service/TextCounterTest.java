package optus.search.searchdemo.service;

import java.util.ArrayList;
import java.util.List;
import optus.search.searchdemo.entity.CountResponseEntity;
import optus.search.searchdemo.exception.GeneralException;
import optus.search.searchdemo.util.MyResourceLoader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ali.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TextCounterTest {

    @Autowired
    private TextCounter textCounter;

    @Test
    public final void testFindText() throws GeneralException {
        List<String> searchTexts = new ArrayList();
        searchTexts.add("Duis");
        searchTexts.add("Sed");
        searchTexts.add("Donec");
        searchTexts.add("Augue");
        searchTexts.add("Pellentesque");
        searchTexts.add("123");
        CountResponseEntity countResponseEntity = this.textCounter.findWordsCount(searchTexts,
                MyResourceLoader.getContent(true));
        Assert.assertNotNull(countResponseEntity);
        Assert.assertEquals(11L, (long)((Long)countResponseEntity.getCounts().get("Duis")).intValue());
        Assert.assertEquals(16L, (long)((Long)countResponseEntity.getCounts().get("Sed")).intValue());
        Assert.assertEquals(8L, (long)((Long)countResponseEntity.getCounts().get("Donec")).intValue());
        Assert.assertEquals(7L, (long)((Long)countResponseEntity.getCounts().get("Augue")).intValue());
        Assert.assertEquals(6L, (long)((Long)countResponseEntity.getCounts().get("Pellentesque")).intValue());
        Assert.assertEquals(0L, (long)((Long)countResponseEntity.getCounts().get("123")).intValue());
    }

    @Test
    public final void testFindTop5OccurenceText() throws Exception {
        String topText = this.textCounter.findWordsTopCount(5, MyResourceLoader.getContent(true));
        Assert.assertEquals("vel|17,eget|17,sed|16,in|15,et|14", topText);
    }

    @Test
    public final void testFindTop10OccurenceText() throws Exception {
        String topText = this.textCounter.findWordsTopCount(10, MyResourceLoader.getContent(true));
        Assert.assertEquals("vel|17,eget|17,sed|16,in|15,et|14,ut|13,eu|13,id|12,ac|12,metus|12", topText);
    }
}
