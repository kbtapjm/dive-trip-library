package io.divetrip.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class AddressDto {

    /* 도시 */
    private String city;

    /* 주소 */
    private String street;

    /* 우편 번호 */
    private String zipCode;

}
