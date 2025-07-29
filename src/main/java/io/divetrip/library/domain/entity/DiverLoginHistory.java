package io.divetrip.library.domain.entity;

import io.divetrip.library.domain.entity.auditing.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "diver_login_history")
public class DiverLoginHistory extends BaseEntity {

    /* 다이버 로그인 이력 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diver_login_history_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID diverLoginHistoryId;

    /* IP 주소 */
    @Column(name = "ip_address", nullable = false, length = 20)
    private String ipAddress;

    /* 다이버 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diver_id", nullable = false, insertable = true, updatable = true)
    private Diver diver;
}
