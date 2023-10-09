package io.divetrip.domain.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Gender {
    MALE("남자"),
    FEMALE("여자");

    private final String description;

}
