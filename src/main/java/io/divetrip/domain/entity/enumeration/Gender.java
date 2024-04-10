package io.divetrip.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("남자"),
    FEMALE("여자");

    private final String description;

    private static final Map<String, Gender> valueAndGenderMap = new HashMap<>();

    static {
        for (Gender gender : Gender.values()) {
            valueAndGenderMap.put(gender.toString(), gender);
        }
    }

    public static Gender findByValue(final String value) {
        return valueAndGenderMap.get(value);
    }

}
