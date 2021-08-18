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
 * 功能描述
 *
 * @author lWX1003749
 * @since 2021-07-07
 */
public class ImportUserReq {
    @JsonProperty("data_type")
    private Integer dataType;

    @JsonProperty("userdata_set")
    private List<UserDataPojo> userDataSet;

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public List<UserDataPojo> getUserDataSet() {
        return userDataSet;
    }

    public void setUserDataSet(List<UserDataPojo> userDataSet) {
        this.userDataSet = userDataSet;
    }
}
