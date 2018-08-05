package optus.search.searchdemo.util;

import optus.search.searchdemo.exception.GeneralException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ali.
 */
public class MyResourceLoader {

    /**
     * Load the resource file.
     *
     * @param toLower If true, will lower case the content.
     * @return The content as a list.
     */
    public static List<String> getContent(boolean toLower) throws GeneralException {

        List data = new ArrayList();
        try {
            Path path = Paths.get(MyResourceLoader.class.getClassLoader().getResource("paragraph.txt").toURI());
            Stream<String> lines = Files.lines(path);
            lines.forEach(line -> data.add(toLower ? line.toLowerCase() : line));
            lines.close();
        } catch (IOException | URISyntaxException e) {
            throw new GeneralException("Cannot load resource due to => " + e.getLocalizedMessage(), e);
        }
        return data;
    }
}
