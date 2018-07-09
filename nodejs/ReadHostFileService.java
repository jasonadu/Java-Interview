import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citibank.afews.nextgen.model.RequestHostFile;

@Service
@Component
public class ReadHostFileService {
	public String getHostFile(String systemFlag,String fileName){
		//read file from nodejs server
		String url = "http://localhost:4000/fileRead";
		RestTemplate restTemplate=new RestTemplate();    
//        AccountWorkListRequest request = restTemplate.getForObject(url, AccountWorkListRequest.class);
		
		RequestHostFile request = new RequestHostFile();
		request.setSystemFlag(systemFlag);
		request.setFileName(fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");

        HttpEntity<RequestHostFile> requestEntity = new HttpEntity<RequestHostFile>(request,headers);

        String responseEntity= restTemplate.postForObject(url, requestEntity, String.class);
        System.out.println(responseEntity);
        
		
		return responseEntity;
	}

}
