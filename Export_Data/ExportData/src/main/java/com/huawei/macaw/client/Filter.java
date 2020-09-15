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

import java.io.Serializable;
import java.util.List;

/**
 * @since 2020-05-28
 */
public class Filter implements Serializable {

    private static final long serialVersionUID = 4786034751802428717L;

    @JsonProperty("name")
    private String filterName;

    @JsonProperty("values")
    private List<String> filterValues;

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterName() { return filterName; }

    public List<String> getFilterValues() {
        return filterValues;
    }

    public void setFilterValues(List<String> filterValues) {
        this.filterValues = filterValues;
    }
}
