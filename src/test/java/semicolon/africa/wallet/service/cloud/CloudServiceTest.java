package semicolon.africa.wallet.service.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static semicolon.africa.wallet.utils.AppUtils.IMAGE_FILE_PATH;

@SpringBootTest
public class CloudServiceTest {
    @Autowired
    private CloudService cloudService;

    @Test
    public void testThatICanUploadFile(){
        Path path = Paths.get(IMAGE_FILE_PATH);
        try(InputStream inputStream = Files.newInputStream(path)){
            MultipartFile file = new MockMultipartFile("testImage", inputStream);
            String response = cloudService.upload(file);
            assertNotNull(response);
            assertThat(response).isNotNull();

        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("File upload failed");
        }
    }
}
