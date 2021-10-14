/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 - 2021 The JfrUnit authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.moditect.jfrunit.events;

/**
 * 
 */
public class G1HeapSummary {
    public static final String EVENT_NAME = "jdk.G1HeapSummary";
    public static final String ATTRIBUTE_STARTTIME_NAME = "startTime";
    public static final String ATTRIBUTE_STARTTIME_TYPE = "long";
    public static final String ATTRIBUTE_GCID_NAME = "gcId";
    public static final String ATTRIBUTE_GCID_TYPE = "int";
    public static final String ATTRIBUTE_WHEN_NAME = "when";
    public static final String ATTRIBUTE_WHEN_TYPE = "String";
    public static final String ATTRIBUTE_EDENUSEDSIZE_NAME = "edenUsedSize";
    public static final String ATTRIBUTE_EDENUSEDSIZE_TYPE = "long";
    public static final String ATTRIBUTE_EDENTOTALSIZE_NAME = "edenTotalSize";
    public static final String ATTRIBUTE_EDENTOTALSIZE_TYPE = "long";
    public static final String ATTRIBUTE_SURVIVORUSEDSIZE_NAME = "survivorUsedSize";
    public static final String ATTRIBUTE_SURVIVORUSEDSIZE_TYPE = "long";
    public static final String ATTRIBUTE_NUMBEROFREGIONS_NAME = "numberOfRegions";
    public static final String ATTRIBUTE_NUMBEROFREGIONS_TYPE = "int";
}
