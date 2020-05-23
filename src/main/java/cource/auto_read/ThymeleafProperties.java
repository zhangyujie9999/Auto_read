package cource.auto_read;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(
        prefix = "spring.thymeleaf"
)
public class ThymeleafProperties {
    private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
    private static final String DEFAULT_PREFIX = "classpath:/templates/";
    private static final String DEFAULT_SUFFIX = ".html";
}
