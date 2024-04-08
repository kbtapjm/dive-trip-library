package io.divetrip.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.function.Supplier;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QueryDslUtils {

    /**
     *
     * @param supplier
     * @return
     */
    public static BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> supplier) {
        try {
            return new BooleanBuilder(supplier.get());
        } catch (IllegalArgumentException | NullPointerException e) {
            return new BooleanBuilder();
        }
    }

    /**
     *
     * @param sort
     * @return
     */
    public static OrderSpecifier<?> createOrderSpecifier(Sort sort) {
        OrderSpecifier<?> orderSpecifier = null;

        for (Sort.Order order : sort) {
            PathBuilder<Object> path = new PathBuilder<Object>(Object.class, order.getProperty());
            orderSpecifier =  new OrderSpecifier(Order.valueOf(order.getDirection().name()), path);
        }

        return orderSpecifier;
    }

}
