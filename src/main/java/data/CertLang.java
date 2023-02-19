package data;

import org.testng.annotations.DataProvider;

public class CertLang {
    @DataProvider
    public static Object[][] getLanguages(){
        return new Object[][]{
                {"ua"},
                {"ru"}};
    }

}
