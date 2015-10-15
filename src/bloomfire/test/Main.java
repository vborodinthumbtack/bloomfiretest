package bloomfire.test;

import bloomfire.test.data.Login;

public class Main
{
    public static final String EMAIL = "vborodin@thumbtack.net";
    public static final String PASS = "Qwer1234";


    public static void main(String[] args)
    {
        Login[] logins=TestLogin.testLogin(EMAIL, PASS);
//        for(Login login:logins)
            TestConnect.testConnect(logins[0]);
            TestConnect.testGetGroupsList(logins[0]);
    }
}
