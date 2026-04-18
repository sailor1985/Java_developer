package Sem_5.DesignAPIForServerApp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.reader")
public class ReaderProperties {
    private int maxAllowedBook;

}
