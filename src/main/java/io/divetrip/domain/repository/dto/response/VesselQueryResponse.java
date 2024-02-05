package io.divetrip.domain.repository.dto.response;

import io.divetrip.domain.entity.enumeration.VesselStatus;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class VesselQueryResponse {

    /* 선박 ID */
    private UUID vesselId;

    /* 선박 명 */
    private String vesselName;

    /* 선박 상태 */
    private VesselStatus vesselStatus;

    /* 총 손님수 */
    private int totalGuests;

    /* 승무원 */
    private int crew;

    /* 캐빈 수 */
    private int numberCabins;

    /* 길이 */
    private String length;

    /* 넓이 */
    private String width;

    /* 선체 */
    private String hull;

    /* 순항 속도 */
    private String crusingSpeed;

    /* 엔진 */
    private String engine;

    /* 발전기 */
    private String generator;

    /* 압축기 */
    private String compressor;

    /* 나이트록스 */
    private String nitrox;

    /* 작은배 */
    private String dinghy;

    /* 워터 메이커 */
    private String waterMakers;

    /* 담수 탱크 */
    private String freshWaterTank;

    /* 디젤 탱크 */
    private String dieselTank;

    /* 범위 */
    private String range;

    /* 사용 여부 */
    private Boolean used;

    /* 등록자 */
    private String createdBy;

    /* 등록일 */
    private LocalDateTime createdAt;

    /* 수정자 */
    private String updatedBy;

    /* 수정일 */
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
