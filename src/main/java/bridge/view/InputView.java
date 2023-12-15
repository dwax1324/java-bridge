package bridge.view;

import bridge.utils.Parser;
import bridge.utils.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();
    InputValidator validator = new InputValidator();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    private enum Message {
        INPUT_MAIN_OPTION("메인 옵션"),
        BRIDGE_SIZE_NOTIFICATION("다리의 길이를 입력해주세요."),
        BRIDGE_UP_OR_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(Message.BRIDGE_SIZE_NOTIFICATION);
                String input = Console.readLine();
                validator.validateBridgeSize(input);
                return Parser.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(Message.BRIDGE_UP_OR_DOWN);
                String input = Console.readLine();
                validator.validateReadMoving(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println(Message.RETRY_OR_QUIT);
                String input = Console.readLine();
                validator.validateGameCommand(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String read() {
        System.out.println(Message.INPUT_MAIN_OPTION.message);
//        return Console.readLine();
        return null;
    }

}