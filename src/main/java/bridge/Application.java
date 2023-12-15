package bridge;

import bridge.controller.Controller;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(InputView.getInstance(), OutputView.getInstance());
        controller.run();
    }
}