package io.divetrip.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PageDto {
    private int pageNo;
    private int pageSize;
    private int totalCount;

    @Builder
    public PageDto(int pageNo, int pageSize) {
        this.pageNo = pageNo - 1;
        this.pageSize = pageSize;
    }

    public void setPage(int pageNo, int pageSize, long totalCount) {
        this.pageNo = pageNo + 1;
        this.pageSize = pageSize;
        this.totalCount = (int) totalCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
