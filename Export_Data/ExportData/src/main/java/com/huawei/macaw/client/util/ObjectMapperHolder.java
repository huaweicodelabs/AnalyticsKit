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

package com.huawei.macaw.client.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * ObjectMapperHolder
 *
 * @since 20191201
 */
public class ObjectMapperHolder {

    public static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * readValue
     *
     * @param content   content
     * @param valueType valueType
     * @return T
     */
    public static <T> T readValue(String content, Class<T> valueType) {

        try {
            return ObjectMapperHolder.MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * writeValue
     *
     * @param object object
     * @return T
     */
    public static String writeValue(Object object) {

        try {
            return ObjectMapperHolder.MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            return null;
        }
    }
}
