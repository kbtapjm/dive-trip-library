package io.divetrip.domain.entity;

import io.divetrip.domain.entity.enumeration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diver_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID diverId;

    @Column(name = "email", nullable = false, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String email;

    @Column(name = "password", nullable = false, length = 15)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String password;

    @Column(name = "family_name", nullable = false, length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String familyName;

    @Column(name = "given_name", nullable = false, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String givenName;

    @Column(name = "gender", nullable = false, length = 10)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthday", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "nationality", length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String nationality;

    @Column(name = "country_code", length = 5)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String countryCode;

    @Column(name = "contact_number", length = 15)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String contactNumber;

    @Column(name = "passport_no", nullable = false, length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String passportNo;

    @Column(name = "passport_expiry_date", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate passportExpiryDate;

    @Column(name = "licensed", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean licensed;

    @Column(name = "created_by", nullable = false, length = 20, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "update_by", nullable = true, length = 20, insertable = false, updatable = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String updatedBy;

    @Column(name = "updated_at", nullable = true, insertable = false, updatable = true)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updateAt;

}
