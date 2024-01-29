package io.divetrip.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SortDto {

    private String sort;
    private String orderBy;

    @JsonIgnore
    public Sort getPageSort() {
        Sort sort = null;

        if (StringUtils.isNotEmpty(this.orderBy)) {
            sort = Sort.by(StringUtils.equals(this.orderBy, "asc") ? Sort.Direction.ASC : Sort.Direction.DESC, this.sort);
        } else {
            sort = Sort.by(Sort.Direction.DESC, "createdAt");
        }

        return sort;
    }

}
