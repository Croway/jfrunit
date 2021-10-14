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
public class JavaThreadStatistics {
    public static final String EVENT_NAME = "jdk.JavaThreadStatistics";
    public static final String ATTRIBUTE_STARTTIME_NAME = "startTime";
    public static final String ATTRIBUTE_STARTTIME_TYPE = "long";
    public static final String ATTRIBUTE_ACTIVECOUNT_NAME = "activeCount";
    public static final String ATTRIBUTE_ACTIVECOUNT_TYPE = "long";
    public static final String ATTRIBUTE_DAEMONCOUNT_NAME = "daemonCount";
    public static final String ATTRIBUTE_DAEMONCOUNT_TYPE = "long";
    public static final String ATTRIBUTE_ACCUMULATEDCOUNT_NAME = "accumulatedCount";
    public static final String ATTRIBUTE_ACCUMULATEDCOUNT_TYPE = "long";
    public static final String ATTRIBUTE_PEAKCOUNT_NAME = "peakCount";
    public static final String ATTRIBUTE_PEAKCOUNT_TYPE = "long";
}
