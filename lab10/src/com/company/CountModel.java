package com.company;

import java.math.BigInteger;

public class CountModel {
    private BigInteger m_total;
    public void reset() {
        m_total = new BigInteger("0");
    }
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigInteger(operand));
    }
    //=================================================================

    /** Set the total value.
     *@param value New value that should be used for the calculator total.
     */
    public void setValue(String value) {
        m_total = new BigInteger(value);
    }

    //=================================================================

    /** Return current calculator total. */
    public String getValue() {
        return m_total.toString();
    }
}
