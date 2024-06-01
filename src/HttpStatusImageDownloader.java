import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        URL url = new URL(imageUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(code + ".jpg");

        byte[] dataBuffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }

        fileOutputStream.close();
        in.close();
    }
}
