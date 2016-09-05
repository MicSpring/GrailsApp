package com.groovyapp.codecs

import org.apache.commons.codec.binary.Base64

/**
 * Created by user on 7/31/2016.
 */
class MyCustomCodec {

    static encode = {str ->
        Base64.encodeBase64(str.getBytes())
    }

    static decode = {str ->
        Base64.decodeBase64(str)
    }
}
