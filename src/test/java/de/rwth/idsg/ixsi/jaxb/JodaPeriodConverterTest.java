package de.rwth.idsg.ixsi.jaxb;

import org.joda.time.Period;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 17.02.2016
 */
public class JodaPeriodConverterTest {

    private static final String isoRepresentation = "PT4080H";
    private static final int repInHours = 4080;

    @Test
    public void sameAsXmlDuration() throws Exception {

        JodaPeriodConverter converter = new JodaPeriodConverter();

        // unmarshal

        Period period = converter.unmarshal(isoRepresentation);
        Assert.assertEquals(repInHours, period.getHours());

        // Safety check with duration

        Duration d1 = DatatypeFactory.newInstance().newDuration(isoRepresentation);
        Assert.assertEquals(repInHours, d1.getHours());

        Assert.assertEquals(d1.toString(), period.toString());

        // marshal

        String str = converter.marshal(period);
        Assert.assertEquals(isoRepresentation, str);

    }
}
