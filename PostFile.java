import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

/**
 * To run the program add Apache HttpClient (https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient)
 * 
 * Author : @IamShivamJaiswal
 */
public class PostFile {
	
	public static String POST(String fileName) throws ClientProtocolException, IOException {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
		
		HttpPost httppost = new HttpPost("https://project-av.onrender.com/analyze");
		
		FileBody fileBody = new FileBody(new File(fileName));
	    
		MultipartEntityBuilder mpEntity = MultipartEntityBuilder
				.create()
				.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
				.addPart("file", fileBody);
	    
		httppost.setEntity(mpEntity.build());
	    
		HttpResponse response = httpclient.execute(httppost);
		
		//System.out.println(response.getStatusLine());
	    
		HttpEntity resEntity = response.getEntity();
		
		return EntityUtils.toString(resEntity);
		
	}
	
  public static void main(String[] args) throws Exception {

	  String fileName = "C://Users//Shivam//Desktop//name.PNG";
	  String result = POST(fileName);
          System.out.println(result);
      
  }
}