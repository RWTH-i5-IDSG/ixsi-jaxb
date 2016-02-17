package de.rwth.idsg.ixsi.jaxb;

import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 17.02.2016
 */
public class JodaPeriodConverter extends XmlAdapter<String, Period> {

    private static final PeriodFormatter PERIOD_FORMATTER = ISOPeriodFormat.standard();

    @Override
    public Period unmarshal(String v) throws Exception {
        if (StringUtils.isNullOrEmpty(v)) {
            return null;
        } else {
            return PERIOD_FORMATTER.parsePeriod(v);
        }
    }

    @Override
    public String marshal(Period v) throws Exception {
        if (v == null) {
            return null;
        } else {
            return PERIOD_FORMATTER.print(v);
        }
    }
}
