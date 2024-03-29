package semicolon.africa.wallet.appConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${cloud.api.name}")
    private String cloudName;
    @Value("${cloud.api.key}")
    private String cloudKey;
    @Value("${cloud.api.secret}")
    private String cloudSecret;

    public String getCloudName() {
        return cloudName;
    }

    public String getCloudKey() {
        return cloudKey;
    }

    public String getCloudSecret() {
        return cloudSecret;
    }
}
