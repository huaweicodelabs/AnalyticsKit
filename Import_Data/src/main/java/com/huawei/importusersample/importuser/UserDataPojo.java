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

package com.huawei.importusersample.importuser;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Object for call import user
 *
 * @since 2021-08-07
 */
public class UserDataPojo {
    @JsonProperty("id")
    private String id;

    @JsonProperty("properties")
    private List<UserPropertyPojo> properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserPropertyPojo> getProperties() {
        return properties;
    }

    public void setProperties(List<UserPropertyPojo> properties) {
        this.properties = properties;
    }
}
