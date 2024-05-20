package io.divetrip.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.divetrip.domain.entity.embedable.Address;
import io.divetrip.domain.entity.enumeration.Gender;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "DIVER", uniqueConstraints = {
        @UniqueConstraint(name = "uc_diver_email", columnNames = {"email"})
})
@EntityListeners(AuditingEntityListener.class)
public class Diver implements Serializable {

    @Serial
    private static final long serialVersionUID = 8228796667151229447L;

    /* 다이버 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diver_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID diverId;

    /* 이메일 */
    @Column(name = "email", nullable = false, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String email;

    /* 비밀번호 */
    @Column(name = "password", nullable = false, length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String password;

    /* 성 */
    @Column(name = "family_name", nullable = false, length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String familyName;

    /* 이름 */
    @Column(name = "given_name", nullable = false, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String givenName;

    /* 성별 */
    @Column(name = "gender", nullable = false, length = 10)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /* 생년월일 */
    @Column(name = "birthday", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /* 국적 */
    @Column(name = "nationality", length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String nationality;

    /* 국가 코드 */
    @Column(name = "country_code", length = 5)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String countryCode;

    /* 전화처 */
    @Column(name = "contact_number", length = 15)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String contactNumber;

    /* 여권 번호 */
    @Column(name = "passport_no", nullable = false, length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String passportNo;

    /* 여권 번호 만료일 */
    @Column(name = "passport_expiry_date", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate passportExpiryDate;

    /* 라이센스 여부 */
    @Column(name = "licensed", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean licensed;

    /* 주소 정보 */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city", length = 50)),
            @AttributeOverride(name = "street", column = @Column(name = "street", length = 200)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", length = 5))
    })
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "diver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiverRole> diverRoles = List.of();

    @Column(name = "created_by", nullable = false, length = 20, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_by", nullable = true, length = 20, insertable = false, updatable = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "updated_at", nullable = true, insertable = false, updatable = true)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void update(String familyName, String givenName, Gender gender, LocalDate birthday, String nationality, String countryCode,
                       String contactNumber, String passportNo, LocalDate passportExpiryDate, Boolean licensed, String city, String street, String zipCode) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.gender = gender;
        this.birthday = birthday;
        this.nationality = nationality;
        this.countryCode = countryCode;
        this.contactNumber = contactNumber;
        this.passportNo = passportNo;
        this.passportExpiryDate = passportExpiryDate;
        this.licensed = licensed;
        this.address = Address.builder().city(city).street(street).zipCode(zipCode).build();
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void addDiverRoles(List<DiverRole> diverRoles) {
        this.diverRoles = diverRoles;
    }

}
