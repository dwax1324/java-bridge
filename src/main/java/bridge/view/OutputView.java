package bridge.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void greeting() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    private enum Message {
        OUTPUT_GAME_START("게임을 시작합니다.");

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
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, boolean isDead) {
        String[][] array = new String[2][bridge.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Arrays.stream(array[i]).map(r -> r = " ").toArray(String[]::new);
        }

        for (int i = 0; i < bridge.size(); i++) {
            handleUp(bridge, isDead, i, array);
            handleDown(bridge, isDead, i, array);
        }

        for (String[] strings : array) {
            StringBuilder res = new StringBuilder("[ ");
            Arrays.stream(strings).forEach(r -> res.append(r).append(" | "));
            res.setLength(res.length() - 2);
            res.append("]");
            System.out.println(res);
        }
    }

    private static void handleDown(List<String> bridge, boolean isDead, int i, String[][] array) {
        if (Objects.equals(bridge.get(i), "D")) {
            if (i + 1 == bridge.size() && isDead) {
                array[0][i] = "X";
                return;
            }
            array[1][i] = "O";
        }
    }

    private static void handleUp(List<String> bridge, boolean isDead, int i, String[][] array) {
        if (Objects.equals(bridge.get(i), "U")) {
            if (i + 1 == bridge.size() && isDead) {
                array[1][i] = "X";
                return;
            }
            array[0][i] = "O";
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printByMessage(String message) {
        System.out.println(message);
    }

}