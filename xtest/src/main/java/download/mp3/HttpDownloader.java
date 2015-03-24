package download.mp3;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
 

class HttpDownloadUtility {
    private static final int BUFFER_SIZE = 4096;
 
    /**
     * Downloads a file from a URL
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
 
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
}

public class HttpDownloader {

	public static void main(String[] args) {
		  String fileURL = "https://r3---sn-n2xjug5oxu-qxae.googlevideo.com/videoplayback?source=youtube&ms=au&requiressl=yes&mv=u&ipbits=0&id=o-AJXxOQB2aFKACWj52ICtCjSVXBKqZA3iq7bbcf9A53nX&pcm2=yes&expire=1414430361&mm=31&mt=1414408740&upn=zMlJFtOI4L8&ip=203.122.17.44&itag=18&sparams=id,ip,ipbits,itag,mm,ms,mv,pcm2,ratebypass,requiressl,source,upn,expire&signature=43CE5D9940064D97ACFBCAEB1F7D0C265327A71F.7D8C365504F6CAE7BB43ED112F5714D75611BE60&fexp=910207,924613,927622,930666,930672,931983,932404,935689,936119,939975,941571,945049,947209,947215,948523,949007,952302,952901,957103&key=yt5&sver=3&ratebypass=yes&quality=medium&type=video/mp4;%20codecs&fallback_host=tc.v9.cache2.googlevideo.com&title=Lecture%20-%2034%20Approximation%20Algorithms%20for%20NP";
	        String saveDir = "C:/mySpace/Download";
	        try {
	            HttpDownloadUtility.downloadFile(fileURL, saveDir);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }

	}

}
