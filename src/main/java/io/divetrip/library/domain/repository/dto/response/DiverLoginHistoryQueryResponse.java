package io.divetrip.library.domain.repository.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DiverLoginHistoryQueryResponse {
    /* 다이버 ID */
    private UUID diverId;

    /* 이메일 */
    private String email;

    /* 로그인 횟수 */
    private int loginCnt;

    /* 마지막 로그인 일시 */
    private LocalDateTime lastLoginDatetime;

    @QueryProjection
    public DiverLoginHistoryQueryResponse(UUID diverId, String email, int loginCnt, LocalDateTime lastLoginDatetime) {
        this.diverId = diverId;
        this.email = email;
        this.loginCnt = loginCnt;
        this.lastLoginDatetime = lastLoginDatetime;
    }
}
