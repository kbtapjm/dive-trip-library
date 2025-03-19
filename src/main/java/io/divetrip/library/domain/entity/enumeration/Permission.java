package io.divetrip.library.domain.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Permission {
    CREATE("등록"),
    READ("조회"),
    UPDATE("수정"),
    DELETE("삭제");

    private final String description;

    private static final Map<String, Permission> valueAndPermissionMap = new HashMap<>();

    static {
        for (Permission permission : Permission.values()) {
            valueAndPermissionMap.put(permission.toString(), permission);
        }
    }

    public static Permission findByValue(final String value) {
        return valueAndPermissionMap.get(value);
    }

}
