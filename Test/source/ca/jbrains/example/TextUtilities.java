package ca.jbrains.example;

import java.util.Arrays;
import java.util.List;

/**
 * Created by enricooliva on 19/02/2017.
 */
public class TextUtilities {
    static List<String> lines(String text) {
        return Arrays.asList(text.split("\\n"));
    }
}
