package main.java;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class GitHubRestClient {

    private String git_url = "";
    private String queryString = "";
    
    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
    
    public GitHubRestClient(String url)
    {
        git_url = url;
    }
    
    public String requestIssues(String username, String password){
        
        String result = "";
        
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
                                    
            HttpGet request = new HttpGet(git_url + queryString);
            
            String userCredentials=  username + ":" + password;
            byte[] encoding = Base64.encodeBase64(userCredentials.getBytes());
            
            String authStringEnc = new String(encoding);
            request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + authStringEnc);
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine sl = response.getStatusLine();   
            
            if(sl.getStatusCode() == 200){
                String bodyAsString = EntityUtils.toString(response.getEntity());
                
                result = bodyAsString;
            }
            else
            {
                System.out.println("Rest call not successfull. Response status code: "+sl.getStatusCode());
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
}
