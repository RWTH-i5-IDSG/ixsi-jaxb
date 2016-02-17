package de.rwth.idsg.ixsi.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Default JAXB mapping: xsd:integer -> java.math.BigInteger
 *
 * We don't need BigInteger for our use cases.
 *
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 29.10.2014
 */
public class IntegerConverter extends XmlAdapter<String, Integer> {
    @Override
    public Integer unmarshal(String v) throws Exception {
        if (StringUtils.isNullOrEmpty(v)) {
            return null;
        } else {
            return new Integer(v);
        }
    }

    @Override
    public String marshal(Integer v) throws Exception {
        if (v == null) {
            return null;
        } else {
            return String.valueOf(v);
        }
    }
}
