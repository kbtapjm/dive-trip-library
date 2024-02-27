package io.divetrip.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "COUNTRY")
public class Country {

    /* 국가 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    /* ISO */
    @Column(name = "iso", nullable = false, length = 2)
    private String iso;

    /* 국가 명 */
    @Column(name = "country_name", nullable = false, length = 80)
    private String countryName;

    /* ISO3 문자 */
    @Column(name = "iso3_char", length = 3)
    private String iso3Char;

    /* ISO3 숫자 */
    @Column(name = "iso3_digit", length = 6)
    private Integer iso3Digit;

    /* 전화 번호 코드 */
    @Column(name = "calling_code", length = 5)
    private Integer callingCode;

    /* 목적지 */
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Destination> destinations = new ArrayList<>();

}
