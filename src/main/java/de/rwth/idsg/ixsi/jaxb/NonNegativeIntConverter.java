package de.rwth.idsg.ixsi.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 29.10.2014
 */
public class NonNegativeIntConverter extends XmlAdapter<String, Integer> {

    @Override
    public Integer unmarshal(String str) throws Exception {
        if (str == null) {
            return null;
        } else {
            Integer i = Integer.valueOf(str);
            return validate(i);
        }
    }

    @Override
    public String marshal(Integer i) throws Exception {
        if (i == null) {
            return null;
        } else {
            return String.valueOf(validate(i));
        }
    }

    private Integer validate(Integer i) {
        if (i < 0) {
            throw new IllegalArgumentException("The number should be non-negative");
        } else {
            return i;
        }
    }
}