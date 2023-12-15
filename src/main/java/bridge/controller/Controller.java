package bridge.controller;


import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.greeting();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeMaker.makeBridge(bridgeSize);
        try {
            playGame();
        } catch (IllegalArgumentException e) {
            outputView.printByMessage(e.getMessage());
        }
    }

    private void playGame() {
        while (true) {
            String moving = inputView.readMoving();
//            BridgeGame.start();
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) {
                break;
            }
        }
    }

}