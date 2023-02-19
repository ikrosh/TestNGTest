import config.BaseCertificate;
import data.CertLang;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.CertificatePage;

import java.util.ResourceBundle;

import static org.testng.Assert.assertEquals;

public class TestWithBundles extends BaseCertificate {

    @Test
    public void verifyCheckButtonIsDisabled()  {
        driver.get("https://certificate.ithillel.ua");
        certificatePage = PageFactory.initElements(driver, CertificatePage.class);
        certificatePage.buttonIsDisabled();
    }


    @Test(dataProvider = "getLanguages",dataProviderClass = CertLang.class)
    public void verifyInvalidCertificate(String lang) throws InterruptedException {
        ResourceBundle bundle=ResourceBundle.getBundle(lang);
        driver.get("https://certificate.ithillel.ua" + bundle.getString("urlEnd"));
        certificatePage = PageFactory.initElements(driver, CertificatePage.class);
        certificatePage.sendCertForm("11111");
        assertEquals(bundle.getString("messer"), certificatePage.getErrorText());
    }

    @Test(dataProvider = "getLanguages",dataProviderClass = CertLang.class)
    public void verifyPageTitle(String lang) throws InterruptedException {
        ResourceBundle bundle=ResourceBundle.getBundle(lang);
        driver.get("https://certificate.ithillel.ua" + bundle.getString("urlEnd"));
        certificatePage = PageFactory.initElements(driver, CertificatePage.class);
        assertEquals(bundle.getString("title"), driver.getTitle());
    }

    @Test(dataProvider = "getLanguages",dataProviderClass = CertLang.class)
    public void verifyTitle(String lang) throws InterruptedException {
        ResourceBundle bundle=ResourceBundle.getBundle(lang);
        driver.get("https://certificate.ithillel.ua" + bundle.getString("urlEnd"));
        certificatePage = PageFactory.initElements(driver, CertificatePage.class);
        assertEquals(bundle.getString("pageheader"), certificatePage.getPageTitle());
    }
}
