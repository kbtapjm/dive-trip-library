package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import io.divetrip.domain.entity.enumeration.VesselStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "VESSEL")
public class Vessel extends BaseEntity {

    /* 선박 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vessel_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID vesselId;

    /* 선박 명 */
    @Column(name = "vessel_name", nullable = false, length = 50, unique = true)
    private String vesselName;

    /* 선박 상태 */
    @Column(name = "vessel_status", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private VesselStatus vesselStatus;

    /* 총 손님수 */
    @Column(name = "total_guests", length = 2)
    private int totalGuests;

    /* 승무원 */
    @Column(name = "crew", length = 2)
    private int crew;

    /* 캐빈 수 */
    @Column(name = "number_cabins", length = 2)
    private int numberCabins;

    /* 길이 */
    @Column(name = "length", length = 20)
    private String length;

    /* 넓이 */
    @Column(name = "width", length = 20)
    private String width;

    /* 선체 */
    @Column(name = "hull", length = 10)
    private String hull;

    /* 순항 속도 */
    @Column(name = "crusing_speed", length = 20)
    private String crusingSpeed;

    /* 엔진 */
    @Column(name = "engine", length = 50)
    private String engine;

    /* 발전기 */
    @Column(name = "generator", length = 50)
    private String generator;

    /* 압축기 */
    @Column(name = "compressor", length = 50)
    private String compressor;

    /* 나이트록스 */
    @Column(name = "nitrox", length = 50)
    private String nitrox;

    /* 작은배 */
    @Column(name = "dinghy", length = 100)
    private String dinghy;

    /* 워터 메이커 */
    @Column(name = "water_makers", length = 100)
    private String waterMakers;

    /* 담수 탱크 */
    @Column(name = "fresh_water_tank", length = 50)
    private String freshWaterTank;

    /* 디젤 탱크 */
    @Column(name = "diesel_tank", length = 50)
    private String dieselTank;

    /* 범위 */
    @Column(name = "`range`", length = 50)
    private String range;

    /* 사용 여부 */
    @Column(name = "used", nullable = false)
    private Boolean used;

    /* 선박 선실 */
    @OneToMany(mappedBy = "vessel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VesselCabin> vesselCabins = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.used = true;
    }

    public void update(String vesselName, VesselStatus vesselStatus, int totalGuests, int crew, int numberCabins, String length, String width, String hull,
                       String crusingSpeed, String engine, String generator, String compressor, String nitrox, String dinghy, String waterMakers, String freshWaterTank, String dieselTank, String range) {
        this.vesselName = vesselName;
        this.vesselStatus = vesselStatus;
        this.totalGuests = totalGuests;
        this.crew = crew;
        this.numberCabins = numberCabins;
        this.length = length;
        this.width = width;
        this.hull = hull;
        this.crusingSpeed = crusingSpeed;
        this.engine = engine;
        this.generator = generator;
        this.compressor = compressor;
        this.nitrox = nitrox;
        this.dinghy = dinghy;
        this.waterMakers = waterMakers;
        this.freshWaterTank = freshWaterTank;
        this.dieselTank = dieselTank;
        this.range = range;
    }

    public void changeUsed(Boolean used) {
        this.used = used;
    }

}
