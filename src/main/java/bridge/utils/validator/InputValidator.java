package bridge.utils.validator;

import bridge.utils.constants.ExceptionMessage;

public class InputValidator extends Validator {

    @Override
    public void validate(String input) {
        validateEnglish(input);
        // 검증 로직 작성
    }

    public void validateBridgeSize(String input) {
        validateNumeric(input);
        validateNumberRange(input, 3, 20);
    }

    public void validateReadMoving(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public void validateGameCommand(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }
}