package org.automation.prisebond;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shantonu on 5/16/2021
 */
public class BondNoReader {

    public static List<String> read() throws URISyntaxException, IOException {
        List<String> ids = new ArrayList<>();
        URL url = BondNoReader.class.getClassLoader().getResource("my-bonds.csv");
        Path path = Paths.get(url.toURI());
        ids = Files.readAllLines(path);
        return ids;
    }
}
