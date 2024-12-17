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
    @DataProvider(name="Invalid mail format")
    public Object[][] getInvalidMailFormatSignup(){
        return new Object[][]{
                {"user@!domain.com","A part following '@' should not contain the symbol '!'."},
                {"user@#domain.com","A part following '@' should not contain the symbol '#'."},
                {"user@%domain.com","A part following '@' should not contain the symbol '%'."},
                {"user@domain$.com","A part following '@' should not contain the symbol '$'."},
                {"user@domain^com","A part following '@' should not contain the symbol '^'."},
                {"user@domain&com","A part following '@' should not contain the symbol '&'."},
                {"user1","Please include an '@' in the email address. 'user1' is missing an '@'."}
        };
    }
    @DataProvider(name = "Exceeding number of characters")
    public Object[][] getInvalidNameWithExceedingCharacters(){
        return new Object[][]{
                {"useruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruser","userw@x.com"},
                {"userw","useruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruser@x.com"}
        };
    }
    @DataProvider(name="CaseSensitive")
    public Object[][] browserData(){
        return new Object[][]{
                {"testuser@x.com"},
                {"TESTUSER@x.com"},
                {"TESTUSER@X.COM"}
        };
    }
    @DataProvider(name="first last Name")
    public Object[][] firstLastNameDate(){
        return new Object[][]{
                {"123456"},
                {"^@#^&#@^"},
                {"55Ahmed55"}
        };
    }@DataProvider(name="valid ZIP Code")
    public Object[][] validZIPCode(){
        return new Object[][]{
                {"12345"}, {"12345-6789"},
        };
    }@DataProvider(name="invalid ZIP Code format/length")
    public Object[][] inValidZIPCode(){
        return new Object[][]{
                {"123@#"},{"123  45"},{"zipco"},{"NM258"},{"١٢٣٤٥"},{"1234"},{"1234567"}
        };
    }
@DataProvider(name="valid Mobile Number")
    public Object[][] MobileNumberData(){
        return new Object[][]{
                {"01020798917"},{"+20102255971"}
        };
    }@DataProvider(name="invalid Mobile Number format/length")
    public Object[][] InValidMobileNumberData(){
        return new Object[][]{
                {"@##%^^$#"},{"+2010  225 5 9 71"},{"0103355TR$"},{"testUser"},{"         "},{"0102255"},{"0000000000"},{"01022559710102255971"}
        };
    }@DataProvider(name="Valid City")
    public Object[][] ValidCityData(){
        return new Object[][]{
                {"Cairo"},{"CAIRO"},{"New York"},{"NEw-York"},{"O'Connor"},{"             cairo       "}
        };
    }@DataProvider(name="InValid City")
    public Object[][] InValidCityData(){
        return new Object[][]{
                {"Cairo12345"},{"&^%^%$@!"},{"            "},{"123456789"},{"NEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-York"}
        };
    }

}
