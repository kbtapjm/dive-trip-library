package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "VESSEL_CABIN")
public class VesselCabin extends BaseEntity {

    /* 선박 선실 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vessel_cabin_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID vesselCabinId;

    /* 선실 명 */
    @Column(name = "cabin_name", nullable = false, length = 50, unique = true)
    private String cabinName;

    /* 설명 */
    @Column(name = "description", length = 500)
    private String description;

    /* 크기 */
    @Column(name = "size", length = 20)
    private String size;

    /* 최대 수용 인원 */
    @Column(name = "max_occupancy", length = 2)
    private int maxOccupancy;

    /* 침구 */
    @Column(name = "bedding", length = 30)
    private String bedding;

    /* 실내 욕실 */
    @Column(name = "ensuite_bathroom")
    private Boolean ensuiteBathroom;

    /* 에어컨 */
    @Column(name = "aircon", length = 20)
    private String aircon;

    /* 사용 여부 */
    @Column(name = "used", nullable = false)
    private Boolean used;

    /* 선박 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_id", nullable = false, insertable = true, updatable = true)
    private Vessel vessel;

    public void update(String cabinName, String description, String size, int maxOccupancy, String bedding, Boolean ensuiteBathroom, String aircon, Boolean used) {
        this.cabinName = cabinName;
        this.description = description;
        this.size = size;
        this.maxOccupancy = maxOccupancy;
        this.bedding = bedding;
        this.ensuiteBathroom = ensuiteBathroom;
        this.aircon = aircon;
        this.used = used;
    }
}
