package io.divetrip.domain.entity;

import io.divetrip.domain.entity.auditing.BaseEntity;
import io.divetrip.domain.entity.enumeration.PaymentMethod;
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
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity {

    /* 결제 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_id", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID paymentId;

    /* 결제 방법 */
    @Column(name = "payment_method", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    /* 결제 금액 */
    @Column(name = "payment_amount", nullable = false, length = 10)
    private Integer paymentAmount;

    /* 결제 일시 */
    @Column(name = "payment_date")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentDate;

    /* 결제 내용 */
    @Column(name = "payment_details", length = 100)
    private String paymentDetails;

    /* 결제 IP */
    @Column(name = "payment_ip", nullable = false, length = 15)
    private String paymentIp;

    /* 입금 계좌 */
    @Column(name = "deposit_account", length = 50)
    private String depositAccount;

    /* 입금자 명 */
    @Column(name = "deposit_name", length = 20)
    private String depositName;

    /* 여행 예약 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_reservation_id", nullable = false, insertable = true, updatable = true)
    private TripReservation tripReservation;

}
