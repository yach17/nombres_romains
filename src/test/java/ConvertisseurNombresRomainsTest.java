import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConvertisseurNombresRomainsTest {

    @DataProvider
    public static Object[][] conversionNombresEnChiffresRomains() {
        return new Object[][]{
                {1, "I"},
                {5, "V"},
                {10, "X"},
                {50, "L"},
                {100, "C"},
                {500, "D"},
                {1000, "M"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {6, "VI"},
                {7, "VII"},
                {8, "VIII"},
                {9, "IX"},
                {11, "XI"},
                {12, "XII"},
                {13, "XIII"},
                {14, "XIV"},
                {15, "XV"},
                {16, "XVI"},
                {17, "XVII"},
                {18, "XVIII"},
                {19, "XIX"},
                {20, "XX"},
                {27, "XXVII"},
                {3789, "MMMDCCLXXXIX"},
                {1999, "MCMXCIX"}
        };
    }

    @Test(dataProvider = "conversionNombresEnChiffresRomains")
    public void testEnChiffresRomains_doit_renvoyer_nombre_romain_pour_nombre(int nombre, String nombreRomainAttendu) {
        ConvertisseurNombresRomains convertisseur = new ConvertisseurNombresRomains();
        String chiffresRomains = convertisseur.enChiffresRomains(nombre);
        Assertions.assertThat(chiffresRomains).isEqualTo(nombreRomainAttendu);
    }
}