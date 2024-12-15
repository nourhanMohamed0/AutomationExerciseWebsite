package TestData;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name="initial signup data")
    public Object[][] getInitialSignupData(){
        return new Object[][]{
                {"123456789","user50@x.com"},
                {"           ","user50@x.com"},
                {"user55","user50@x.com"},
                {"      user        ","user50@x.com"}
        };
    }
}
