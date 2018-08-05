
package optus.search.searchdemo.controller;

import optus.search.searchdemo.entity.CountResponseEntity;
import optus.search.searchdemo.entity.SearchRequestBody;
import optus.search.searchdemo.service.TextCounter;
import optus.search.searchdemo.util.MyResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/counter", "counter-api"})
public class SearchWordsController {
    private static final Logger logger = LoggerFactory.getLogger(SearchWordsController.class);

    @Autowired
    private TextCounter textCounter;

    @RequestMapping(value = {"/search"}, method = {RequestMethod.POST}, headers = {"Accept=application/json"})
    public ResponseEntity<CountResponseEntity> countText(@RequestBody SearchRequestBody searchText) {
        logger.info("searchText is => {}", searchText);
        CountResponseEntity countResponseEntity = this.textCounter.findWordsCount(searchText.getSearchText(), MyResourceLoader.getContent(true));
        logger.info("Result of searchText counts is => {}", countResponseEntity);
        return new ResponseEntity(countResponseEntity, HttpStatus.OK);
    }

    @RequestMapping(value = {"/top/{topCount}"}, method = {RequestMethod.GET})
    @ResponseBody
    public String topText(@PathVariable("topCount") int topCount) {
        logger.info("Top texts count is => {}", topCount);
        return this.textCounter.findWordsTopCount(topCount, MyResourceLoader.getContent(true)).replaceAll(",", "\n");
    }
}
