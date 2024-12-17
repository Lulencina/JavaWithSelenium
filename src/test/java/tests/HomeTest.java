package tests;
import com.github.javafaker.Faker;
import org.example.CheckoutPage;
import org.example.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver.DriverManager;

public class HomeTest {
private HomePage homePage;
private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get("http://logofree.esy.es/");
        homePage = new HomePage();
    }
    @Test
    public void testGoToCheckOutPage() {
        //  Libreria Faker
        Faker faker = new Faker();
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String direccion = faker.address().fullAddress();
        String ciudad = faker.address().city();
        String postal = faker.address().zipCode();
        String telefono = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();

        // Agregamos el producto
        homePage.addProductToCart();

        // Vamos al Carrito
        checkoutPage = homePage.goToCart();

        // Vamos al checkout
        checkoutPage.clickProceedToCheckout();

        // Completamos los datos del formulario
        checkoutPage.enterFirstName(nombre);
        checkoutPage.enterLastName(apellido);
        checkoutPage.selectCountry("Thailand");
        checkoutPage.enterStreetAdress(direccion);
        checkoutPage.enterCity(ciudad);
        checkoutPage.selectState("Bangkok");
        checkoutPage.enterZip(postal);
        checkoutPage.enterPhone(telefono);
        checkoutPage.enterEmail(email);
        checkoutPage.clickProceedToPay();
    }
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}