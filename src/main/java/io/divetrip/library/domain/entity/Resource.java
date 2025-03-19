package io.divetrip.library.domain.entity;

import io.divetrip.library.domain.entity.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
@Table(name = "RESOURCE")
public class Resource extends BaseEntity {

    /* 리소스 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "resource_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID resourceId;

    /* 그룹 ID */
    @Column(name = "group_id")
    private UUID groupId;

    /* 리소스 명 */
    @Column(name = "resource_name", nullable = false, length = 50)
    private String resourceName;

    /* 리소스 URL */
    @Column(name = "resource_url", nullable = false, length = 50)
    private String resourceUrl;

    /* 리소스 설명 */
    @Column(name = "resource_desc", length = 100)
    private String resourceDesc;

    /* 리소스 순서 */
    @Column(name = "resource_order", length = 2)
    private Integer resourceOrder;

    /* 사용 여부 */
    @Column(name = "used", nullable = false)
    private Boolean used;

    @PrePersist
    public void prePersist() {
        this.used = true;
    }

    public void update(String resourceName, String resourceUrl, String resourceDesc, Integer resourceOrder) {
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceDesc = resourceDesc;
        this.resourceOrder = resourceOrder;
    }

}
