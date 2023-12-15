package bridge.utils.validator;

public class ParserValidator extends Validator {
    @Override
    public void validate(String input) {
        validateParsible(input);
    }
}
