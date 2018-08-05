package optus.search.searchdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyResourceLoader {
    private static final Logger logger = LoggerFactory.getLogger(MyResourceLoader.class);

    public static List<String> getContent(boolean toLower) {

        List data = new ArrayList();
        try {
            Path path = Paths.get(MyResourceLoader.class.getClassLoader().getResource("paragraph.txt").toURI());
            Stream<String> lines = Files.lines(path);
            lines.forEach(line -> data.add(toLower ? line.toLowerCase() : line));
            lines.close();
        } catch (IOException | URISyntaxException e) {
            logger.error("Cannot load resource due to => {}", e.getLocalizedMessage());
        }
        return data;
    }
}
