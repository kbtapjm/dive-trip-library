package io.divetrip.library.domain.repository.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class DiverLoginHistoryQueryRequest {
    /* 다이버 ID */
    private UUID diverId;

    /* 이메일 */
    private String email;
}
