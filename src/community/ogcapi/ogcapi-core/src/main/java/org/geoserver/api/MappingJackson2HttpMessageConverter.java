package org.geoserver.api;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.springframework.http.MediaType;

/**
 * GeoServer extension of MappingJackson2HttpMessageConverter allowing to mark a bean so that it
 * won't get serialized
 */
public class MappingJackson2HttpMessageConverter
        extends org.springframework.http.converter.json.MappingJackson2HttpMessageConverter {

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if (clazz.getAnnotation(JsonIgnoreType.class) != null) {
            return false;
        }
        return super.canWrite(clazz, mediaType);
    }
}
