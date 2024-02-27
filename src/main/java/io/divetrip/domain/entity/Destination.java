package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import io.divetrip.domain.entity.enumeration.Continent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "DESTINATION")
public class Destination extends BaseEntity {

    /* 목적지 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "destination_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID destinationId;

    /* 대륙 */
    @Column(name = "continent", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Continent continent;

    /* 지역 */
    @Column(name = "area", nullable = false, length = 30)
    private String area;

    /* 설명 */
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    /* 국가 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = true, updatable = true)
    private Country country;

    public void update(Continent continent, String area, String description, Country country) {
        this.continent = continent;
        this.area = area;
        this.description = description;
        this.country = country;
    }

}
