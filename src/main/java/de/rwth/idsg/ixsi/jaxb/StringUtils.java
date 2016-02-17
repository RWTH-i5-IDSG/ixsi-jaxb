package de.rwth.idsg.ixsi.jaxb;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 17.02.2016
 */
public final class StringUtils {

    private StringUtils() { }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
