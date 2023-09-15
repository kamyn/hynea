package ru.hynea.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Slf4j
@Configuration
public class ImageDirConfig {
    @Value("${images.path}")
    private String imagesPath;

    @PostConstruct
    private void mkDirIfNotExist() {
        File imageDir = new File(imagesPath);
        if (!imageDir.exists()) {
            boolean result = imageDir.mkdir();
            if (!result) {
                log.warn("images folder not created");
            }
        }
    }
}
