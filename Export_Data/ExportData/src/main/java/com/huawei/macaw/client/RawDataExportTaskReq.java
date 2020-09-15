/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.



   Licensed under the Apache License, Version 2.0 (the "License");

   you may not use this file except in compliance with the License.

   You may obtain a copy of the License at



     http://www.apache.org/licenses/LICENSE-2.0



   Unless required by applicable law or agreed to in writing, software

   distributed under the License is distributed on an "AS IS" BASIS,

   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

   See the License for the specific language governing permissions and

   limitations under the License.
 */

package com.huawei.macaw.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * RawDataExportTask
 *
 * @since 2020/5/29
 */
public class RawDataExportTaskReq {

    @JsonProperty("date_range")
    private DateRange dateRange;

    @JsonProperty("file_format")
    private String fileFormat;

    @JsonProperty("filters")
    private List<Filter> filters;

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }
}
