/**
 * Copyright (c) 2011-2013, ReXSL.com
 * All rights reserved.
 */
package MySelenium.MySelenium.rexsl.scripts

import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.RestResponse
import com.jcabi.http.response.XmlResponse

[
    '/page-doesnt-exist',
    '/xsl/xsl-stylesheet-doesnt-exist.xsl',
    '/css/stylesheet-is-absent.css',
].each {
    new JdkRequest(rexsl.home)
        .uri().path(it).back()
        .fetch()
        .as(RestResponse.class)
        .assertStatus(HttpURLConnection.HTTP_NOT_FOUND)
        .as(XmlResponse.class)
        .assertXPath('//xhtml:h1[contains(.,"Page not found")]')
}
