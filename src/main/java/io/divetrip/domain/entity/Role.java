package io.divetrip.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.divetrip.domain.entity.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity {

    /* 역할 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID roleId;

    /* 역할 코드 */
    @Column(name = "role_code", nullable = false, length = 20)
    private String roleCode;

    /* 역할 명 */
    @Column(name = "role_name", nullable = false, length = 30)
    private String roleName;

    /* 다이버 역할 */
    @JsonBackReference
    @OneToMany(mappedBy = "role")
    private List<DiverRole> diverRoles = List.of();

}
