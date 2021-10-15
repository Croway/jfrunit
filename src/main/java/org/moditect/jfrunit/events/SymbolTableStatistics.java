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

import org.moditect.jfrunit.Attribute;
import org.moditect.jfrunit.JfrEventType;
import org.moditect.jfrunit.events.model.*;

/**
 * 
 */
public class SymbolTableStatistics extends JfrEventType {
    public static final SymbolTableStatistics INSTANCE = new SymbolTableStatistics();
    public static final String EVENT_NAME = "jdk.SymbolTableStatistics";
    public static final Attribute<SymbolTableStatistics, java.time.Instant> START_TIME = new Attribute("startTime");
    public static final Attribute<SymbolTableStatistics, Long> BUCKET_COUNT = new Attribute("bucketCount");
    public static final Attribute<SymbolTableStatistics, Long> ENTRY_COUNT = new Attribute("entryCount");
    public static final Attribute<SymbolTableStatistics, Long> TOTAL_FOOTPRINT = new Attribute("totalFootprint");
    public static final Attribute<SymbolTableStatistics, Long> BUCKET_COUNT_MAXIMUM = new Attribute("bucketCountMaximum");
    public static final Attribute<SymbolTableStatistics, Float> BUCKET_COUNT_AVERAGE = new Attribute("bucketCountAverage");
    public static final Attribute<SymbolTableStatistics, Float> BUCKET_COUNT_VARIANCE = new Attribute("bucketCountVariance");
    public static final Attribute<SymbolTableStatistics, Float> BUCKET_COUNT_STANDARD_DEVIATION = new Attribute("bucketCountStandardDeviation");
    public static final Attribute<SymbolTableStatistics, Float> INSERTION_RATE = new Attribute("insertionRate");
    public static final Attribute<SymbolTableStatistics, Float> REMOVAL_RATE = new Attribute("removalRate");

    public SymbolTableStatistics() {
        super(EVENT_NAME);
    }
}
