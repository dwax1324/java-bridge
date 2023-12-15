package bridge.domain;

import java.util.List;

public record BridgeGameDto(List<String> map, Integer counter, boolean isDead) {
}