package de.rwth.idsg.ixsi.jaxb;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import xjc.schema.ixsi.BookingTargetIDType;
import xjc.schema.ixsi.ProviderPlaceIDType;
import xjc.schema.ixsi.TransactionType;
import xjc.schema.ixsi.UserInfoType;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 20.07.2015
 */
public class EqualsTest {

    @Test
    public void transactionsEqual() {
        DateTime dt = new DateTime();
        TransactionType item1 = new TransactionType().withMessageID(1).withTimeStamp(dt);
        TransactionType item2 = new TransactionType().withMessageID(1).withTimeStamp(dt);
        Assert.assertTrue(item1.equals(item2));

        item1.setMessageID(2);
        Assert.assertFalse(item1.equals(item2));
    }

    @Test
    public void bookingTargetsEqual() {
        BookingTargetIDType item1 = new BookingTargetIDType().withBookeeID("bo").withProviderID("pro");
        BookingTargetIDType item2 = new BookingTargetIDType().withBookeeID("bo").withProviderID("pro");
        Assert.assertTrue(item1.equals(item2));

        item1.setBookeeID("hz");
        Assert.assertFalse(item1.equals(item2));
    }

    @Test
    public void providerPlacesEqual() {
        ProviderPlaceIDType item1 = new ProviderPlaceIDType().withPlaceID("pl").withProviderID("pro");
        ProviderPlaceIDType item2 = new ProviderPlaceIDType().withPlaceID("pl").withProviderID("pro");
        Assert.assertTrue(item1.equals(item2));

        item1.setProviderID("hz");
        Assert.assertFalse(item1.equals(item2));
    }

    @Test
    public void userInfosEqual() {
        UserInfoType item1 = new UserInfoType().withUserID("us1").withProviderID("pro");
        UserInfoType item2 = new UserInfoType().withUserID("us1").withProviderID("pro");
        Assert.assertTrue(item1.equals(item2));

        item1.setUserID("hz");
        Assert.assertFalse(item1.equals(item2));
    }
}
