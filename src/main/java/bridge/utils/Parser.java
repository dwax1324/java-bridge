package bridge.utils;

import bridge.utils.validator.ParserValidator;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> parseByDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public static Integer parseInt(String input) {
        ParserValidator validator = new ParserValidator();
        validator.validate(input);
        return Integer.parseInt(input);
    }

}