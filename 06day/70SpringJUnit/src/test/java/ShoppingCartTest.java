import com.jasdhir.springdemo.AppConfig;
import com.jasdhir.springdemo.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ShoppingCartTest {

    @Autowired // field injection
    private ShoppingCart shoppingCart;

    @Test
    public void testCheckout() {
        shoppingCart.addItem("Item1", 3);
        shoppingCart.addItem("item2", 5);
        String result = shoppingCart.checkout();
        Assert.assertEquals("2 orders placed", result);
    }
}
