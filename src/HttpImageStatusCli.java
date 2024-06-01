import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter HTTP status code: ");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int code = scanner.nextInt();
                HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
                try {
                    downloader.downloadStatusImage(code);
                    System.out.println("Image downloaded successfully for HTTP status " + code);
                } catch (Exception e) {
                    System.out.println("There is not image for HTTP status " + code);
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
            System.out.print("Enter HTTP status code: ");
        }
        scanner.close();
    }


}
