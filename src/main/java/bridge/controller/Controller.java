package bridge.controller;


import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

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
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        try {
            playGame(bridge);
        } catch (IllegalArgumentException e) {
            outputView.printByMessage(e.getMessage());
        }
    }

    private void playGame(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (true) {
            String direction = inputView.readMoving();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getMap(), bridgeGame.isDead());
            if (handleSuccess(bridge, bridgeGame)) {
                break;
            }
            if (handleDead(bridgeGame)) {
                break;
            }
        }
    }

    private boolean handleDead(BridgeGame bridgeGame) {
        if (bridgeGame.isDead()) {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) {
                return true;
            }
            bridgeGame.retry();
        }
        return false;
    }

    private boolean handleSuccess(List<String> bridge, BridgeGame bridgeGame) {
        if (bridgeGame.getPosition() == bridge.size()) {
            outputView.printResult();
            return true;
        }
        return false;
    }
}