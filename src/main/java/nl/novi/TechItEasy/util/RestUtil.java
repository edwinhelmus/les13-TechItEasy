package nl.novi.TechItEasy.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class RestUtil {
    public static URI constructURI(Long id) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.
                        fromCurrentRequest().
                        path("/" + id).toUriString());
        return uri;
    }

}
