package io.divetrip.library.domain.entity;

import io.divetrip.library.domain.entity.enumeration.Permission;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ROLE_RESOURCE_PERMISSION")
public class RoleResourcePermission {

    /* 롤 리소스 퍼미션 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_resource_permission_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID roleResourcePermissionId;

    /* 권한 */
    @Column(name = "permission", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Permission permission;

    /* 등록 시간 */
    @CreatedDate
    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /* 역할 리소스 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_resource_id", nullable = false, insertable = true, updatable = true)
    private RoleResource roleResource;

    @PrePersist
    public void perPersist() {
        this.createdAt = LocalDateTime.now();
    }

}
