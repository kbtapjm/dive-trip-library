package io.divetrip.library.domain.entity;

import io.divetrip.library.domain.entity.embedable.Address;
import io.divetrip.library.domain.entity.enumeration.Gender;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "DIVER_DORMANT", uniqueConstraints = {
        @UniqueConstraint(name = "uc_diver_email", columnNames = {"email"})
})
public class DiverDormant implements Serializable {

    /* 다이버 휴면 ID */
    @Id
    @Column(name = "diver_dormant_id", nullable = false)
    private UUID diverDormantId;

    /* 이메일 */
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    /* 비밀번호 */
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    /* 성 */
    @Column(name = "family_name", nullable = false, length = 20)
    private String familyName;

    /* 이름 */
    @Column(name = "given_name", nullable = false, length = 50)
    private String givenName;

    /* 성별 */
    @Column(name = "gender", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /* 생년월일 */
    @Column(name = "birthday", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /* 국적 */
    @Column(name = "nationality", length = 20)
    private String nationality;

    /* 국가 코드 */
    @Column(name = "country_code", length = 5)
    private String countryCode;

    /* 연락처 */
    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    /* 여권 번호 */
    @Column(name = "passport_no", nullable = false, length = 20)
    private String passportNo;

    /* 여권 번호 만료일 */
    @Column(name = "passport_expiry_date", nullable = false)
    private LocalDate passportExpiryDate;

    /* 라이센스 여부 */
    @Column(name = "licensed", nullable = false)
    private Boolean licensed;

    /* 주소 정보 */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city", length = 50)),
            @AttributeOverride(name = "street", column = @Column(name = "street", length = 200)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", length = 5))
    })
    private Address address;

    /* 활성화 여부 */
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true, insertable = false, updatable = true)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
