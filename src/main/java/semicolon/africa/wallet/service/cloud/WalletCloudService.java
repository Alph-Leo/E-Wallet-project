package semicolon.africa.wallet.service.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import semicolon.africa.wallet.appConfig.AppConfig;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletCloudService implements CloudService{
    private final AppConfig appConfig;
    @Override
    public String upload(MultipartFile file) {
        Cloudinary cloudinary = new Cloudinary();
        Uploader uploader = cloudinary.uploader();

        try {
            Map<?,?> response = uploader.upload(file.getBytes(), ObjectUtils.asMap(
                    "public_id", "myWallet/user/uploaded files/" + UUID.randomUUID(),
                    "cloud_name", appConfig.getCloudName(),
                    "api_key", appConfig.getCloudKey(),
                    "api_secret", appConfig.getCloudSecret(),
                    "secure", true
            ));
            return response.get("url").toString();

        } catch (IOException exception){
            throw new RuntimeException("Failed to upload file");
        }
    }
}
