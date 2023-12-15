package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private Integer positon;
    private Integer gameCounter;

    private boolean dead;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        gameCounter = 1;
        positon = 0;
        dead = false;
    }

    public void incrementGameCounter() {
        gameCounter++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (!bridge.get(positon++).equals(direction)) {
            dead = true;
        }
        return;
    }

    public List<String> getMap() {
        return bridge.subList(0, getPosition());
    }

    public Integer getPosition() {
        return positon;
    }

    public boolean isDead() {
        return dead;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        positon = 0;
        dead = false;
        incrementGameCounter();
    }

    public BridgeGameDto toDto() {
        return new BridgeGameDto(getMap(), gameCounter, isDead());
    }
}