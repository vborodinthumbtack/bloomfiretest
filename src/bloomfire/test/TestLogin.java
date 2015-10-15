package bloomfire.test;

import bloomfire.test.data.Login;
import com.google.gson.Gson;

/**
 * Created by Vlad on 15.10.15.
 */
public class TestLogin
{

    public static Login[] testLogin(String email,String pass)
    {
        String loginRequest = NetWork.request("https://start.bloomfire.mobi/api/v2/logins?email=" + email
                + "&password=" + pass + "&fields=" + Constants.LOGIN_FIELDS);
        assert loginRequest != null;
        assert !loginRequest.equals("error 404");
        Login[] logins = new Gson().fromJson(loginRequest, Login[].class);
        assert logins != null;
        System.out.println(loginRequest);
        for (Login login : logins)
        {
            login.assertNotNull();
        }

        return logins;
    }
}
