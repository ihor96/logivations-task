package businessLogicsTests;

import com.logivations.controllers.Controller;
import com.logivations.models.Case;
import com.logivations.models.Order;
import com.logivations.models.Product;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BusinessLogicTest {
    List<Case> cases;
    List<Order> orders;

    public BusinessLogicTest() {
        cases = new ArrayList<>();
        orders = new ArrayList<>();
        List<Product> pr = new ArrayList<>();

        pr.add(new Product(1.1, 1.2, 1.3));
        pr.add(new Product(6, 3, 1));
        pr.add(new Product(1, 2, 3));
        pr.add(new Product(3, 2, 2));

        cases.add(new Case(7, 3, 1));
        cases.add(new Case(1.1, 1.3, 1.4));
        cases.add(new Case(2, 1, 3));
        cases.add(new Case(5, 3, 1));
        orders.add(new Order(4, pr));
    }

    @Test
    public void volumeTest() {
        for (Case casee : new Controller().checkAndPutProductsInCase(cases, orders)) {
            Assert.assertTrue(casee.getCaseV() >= casee.getProduct().getProductV());
        }
    }

    @Test
    public void differentElementsTest() {
        Assert.assertNotSame(new Controller().checkAndPutProductsInCase(cases, orders).get(0), new Controller().checkAndPutProductsInCase(cases, orders).get(1));
    }

    @Test
    public void elementsCountTest() {
        Assert.assertEquals(new Controller().checkAndPutProductsInCase(cases, orders).size(), 3);
    }
}



