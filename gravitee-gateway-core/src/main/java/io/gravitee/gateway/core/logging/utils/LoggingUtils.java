/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.core.logging.utils;

import io.gravitee.gateway.api.ExecutionContext;

import java.util.List;

import static io.gravitee.common.http.MediaType.*;
import static io.gravitee.common.http.MediaType.TEXT_HTML;
import static java.util.Arrays.asList;

/**
 * @author Titouan COMPIEGNE (titouan.compiegne at graviteesource.com)
 * @author GraviteeSource Team
 */
public final class LoggingUtils {

    private static final List<String> RESPONSE_CONTENT_TYPES_TO_INCLUDE = asList(APPLICATION_JSON, APPLICATION_XML,
            APPLICATION_ATOM_XML, APPLICATION_XHTML_XML, TEXT_PLAIN, TEXT_XML, TEXT_HTML);

    public static int getMaxSizeLogMessage(ExecutionContext executionContext) {
        try {
            return (int) executionContext.getAttribute(ExecutionContext.ATTR_PREFIX + "logging.max.size.log.message");
        } catch (Exception ex) {
            return -1;
        }
    }

    public static boolean isResponseContentTypeLoggable(final String contentType) {
        return contentType == null || RESPONSE_CONTENT_TYPES_TO_INCLUDE.contains(contentType.toLowerCase());
    }
}
