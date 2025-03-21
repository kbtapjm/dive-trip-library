package io.divetrip.library.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ROLE_RESOURCE")
public class RoleResource {

    /* 역할 리소스 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_resource_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID roleResourceId;

    /* 역할 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, insertable = true, updatable = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Role role;

    /* 리소스 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false, insertable = true, updatable = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Resource resource;

    /* 등록 시간 */
    @CreatedDate
    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /* 역활 리소스 퍼미션 목록 */
    @Builder.Default
    @OneToMany(mappedBy = "roleResource", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleResourcePermission> permissions = new ArrayList<>();

}
