package de.rwth.idsg.ixsi.jaxb;

import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;

/**
 * Overrides, customizes some default behaviors.
 *
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 31.07.2015
 */
public class IxsiToStringStrategy extends JAXBToStringStrategy {
    public static final ToStringStrategy INSTANCE = new IxsiToStringStrategy();

    /**
     * Do not print full class name (including the package)
     */
    @Override
    protected void appendClassName(StringBuilder buffer, Object object) {
        if (object != null) {
            buffer.append(getShortClassName(object.getClass()));
        }
    }

    /**
     * Do not append the hash code of the instance after the class name.
     */
    @Override
    public boolean isUseIdentityHashCode() {
        return false;
    }

    /**
     * Print just "null" instead of "<null>"
     */
    @Override
    protected void appendNullText(StringBuilder buffer) {
        buffer.append("null");
    }

    /**
     * In order to be compatible with Lombok's style
     */
    @Override
    protected void appendContentStart(StringBuilder buffer) {
        buffer.append('(');
    }

    /**
     * In order to be compatible with Lombok's style
     */
    @Override
    protected void appendContentEnd(StringBuilder buffer) {
        buffer.append(')');
    }
}
