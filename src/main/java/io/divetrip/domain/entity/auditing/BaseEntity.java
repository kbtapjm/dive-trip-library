package io.divetrip.domain.entity.auditing;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@MappedSuperclass
public class BaseEntity extends BaseTimeEntity {

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 20, insertable = true, updatable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = true, length = 20, insertable = false, updatable = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String updatedBy;

}
