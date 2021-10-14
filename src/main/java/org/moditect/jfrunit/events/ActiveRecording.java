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
public class ActiveRecording {
    public static final String EVENT_NAME = "jdk.ActiveRecording";
    public static final String ATTRIBUTE_STARTTIME_NAME = "startTime";
    public static final String ATTRIBUTE_STARTTIME_TYPE = "long";
    public static final String ATTRIBUTE_DURATION_NAME = "duration";
    public static final String ATTRIBUTE_DURATION_TYPE = "long";
    public static final String ATTRIBUTE_EVENTTHREAD_NAME = "eventThread";
    public static final String ATTRIBUTE_EVENTTHREAD_TYPE = "Thread";
    public static final String ATTRIBUTE_STACKTRACE_NAME = "stackTrace";
    public static final String ATTRIBUTE_STACKTRACE_TYPE = "StackTrace";
    public static final String ATTRIBUTE_ID_NAME = "id";
    public static final String ATTRIBUTE_ID_TYPE = "long";
    public static final String ATTRIBUTE_NAME_NAME = "name";
    public static final String ATTRIBUTE_NAME_TYPE = "String";
    public static final String ATTRIBUTE_DESTINATION_NAME = "destination";
    public static final String ATTRIBUTE_DESTINATION_TYPE = "String";
    public static final String ATTRIBUTE_MAXAGE_NAME = "maxAge";
    public static final String ATTRIBUTE_MAXAGE_TYPE = "long";
    public static final String ATTRIBUTE_FLUSHINTERVAL_NAME = "flushInterval";
    public static final String ATTRIBUTE_FLUSHINTERVAL_TYPE = "long";
    public static final String ATTRIBUTE_MAXSIZE_NAME = "maxSize";
    public static final String ATTRIBUTE_MAXSIZE_TYPE = "long";
    public static final String ATTRIBUTE_RECORDINGSTART_NAME = "recordingStart";
    public static final String ATTRIBUTE_RECORDINGSTART_TYPE = "long";
    public static final String ATTRIBUTE_RECORDINGDURATION_NAME = "recordingDuration";
    public static final String ATTRIBUTE_RECORDINGDURATION_TYPE = "long";
}
