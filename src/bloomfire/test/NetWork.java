package bloomfire.test;

import bloomfire.test.data.Login;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by Vlad on 15.10.15.
 */
public class NetWork
{
    static String request(String url)
    {
        try
        {
            HttpGet hg = new HttpGet(new URI(url));

            BasicHttpParams httpParameters = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(httpParameters, 10000);
            HttpConnectionParams.setSoTimeout(httpParameters, 10000);

            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            CloseableHttpResponse httpResponse = httpClient.execute(hg);

            if (httpResponse.getStatusLine().getStatusCode() != 200)
            {
                return "error " + httpResponse.getStatusLine().getStatusCode();
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null)
            {
                return "error entity=null";
            }
            InputStream instream = entity.getContent();
            String str = convertStreamToString(instream);
            instream.close();
            return str;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static String requestWithToken(final Login login, String url)
    {
//        System.out.println(login.getAPIUrl()+url);
        try
        {
            HttpGet hg = new HttpGet(new URI(login.getAPIUrl() + url));

            BasicHttpParams httpParameters = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(httpParameters, 10000);
            HttpConnectionParams.setSoTimeout(httpParameters, 10000);

            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            httpClient.addRequestInterceptor(new HttpRequestInterceptor()
            {
                @Override
                public void process(HttpRequest request, HttpContext httpContext) throws HttpException, IOException
                {
                    request.addHeader("Bloomfire-Secret", "HtwACwbyApIoXJDFu8CT9o8yf7SFRvG8");
                    request.addHeader("Bloomfire-Session-Token", login.session_token);
                    request.addHeader("Bloomfire-Mobile", "1|ios|0.80|com.bloomfire.bloomfire|0.80|20150307|8.1|iPad Simulator");
                }
            });
            CloseableHttpResponse httpResponse = httpClient.execute(hg);

            if (httpResponse.getStatusLine().getStatusCode() != 200)
            {
                return "error " + httpResponse.getStatusLine().getStatusCode();
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null)
            {
                return "error entity=null";
            }
            InputStream instream = entity.getContent();
            String str = convertStreamToString(instream);
            instream.close();
            return str;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static public Object requestWithTokenAndAssert(final Login login, String url, Class type)
    {
        String orgRequest = NetWork.requestWithToken(login, url);
        System.out.println(orgRequest);
        assert orgRequest != null;
        assert !orgRequest.equals("error 404");
        return new Gson().fromJson(orgRequest, type);
    }

    public static String convertStreamToString(InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is), 65536);
        StringBuilder sb = new StringBuilder();

        String line = null;
        try
        {
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch (IOException e)
        {
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
            }
        }
        return sb.toString();
    }
}
