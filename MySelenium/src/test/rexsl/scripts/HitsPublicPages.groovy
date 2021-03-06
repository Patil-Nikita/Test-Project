/**
 * Copyright (c) 2011-2013, ReXSL.com
 * All rights reserved.
 */
package MySelenium.MySelenium.rexsl.scripts

import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.RestResponse

[
    '/',
    '/robots.txt',
    '/xsl/layout.xsl',
    '/xsl/index.xsl',
    '/css/screen.css',
].each {
    new JdkRequest(rexsl.home)
        .uri().path(it).back()
        .fetch()
        .as(RestResponse.class)
        .assertStatus(HttpURLConnection.HTTP_OK)
}
