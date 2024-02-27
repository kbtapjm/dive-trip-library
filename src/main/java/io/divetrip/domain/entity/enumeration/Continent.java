package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Continent {
    AFRICA("아프리카"),
    ASIA("아시아"),
    MIDDLE_EAST("중동"),
    EUROPE("유럽"),
    SOUTH_AMERICA("남아메리카"),
    NORTH_AMERICA("북아메리카"),
    OCEAINA("오세아니아");

    private final String description;

    private static final Map<String, Continent> valueAndContinentMap = new HashMap<>();

    static {
        for (Continent continent : Continent.values()) {
            valueAndContinentMap.put(continent.toString(), continent);
        }
    }

    public static Continent findByValue(final String value) {
        return valueAndContinentMap.get(value);
    }

}
