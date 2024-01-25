package io.divetrip.domain.entity.embedable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class Address {

    private String city;
    private String street;
    private String zipCode;

}
