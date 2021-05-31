package utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public List<String> readFileAsList(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());

        return lines;
    }
}
