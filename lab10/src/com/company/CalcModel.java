package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
public class CalcModel {
    //... Constants
    static final String INITIAL_VALUE = "1";

    //... Member variable defining state of calculator.
    private BigInteger m_total; // The total current value state.

    //==============================================================

    /** Constructor */
    CalcModel() {
        reset();
    }

    //====================================================================

    /** Reset to initial value. */
    public void reset() {
        m_total = new BigInteger(INITIAL_VALUE);
    }

    //===============================================================

    /** Multiply current total by a number.
     *@param operand Number (as string) to multiply total by.
     */
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigInteger(operand));
    }
    //=================================================================
    public void addBy(String operand) {
        m_total = m_total.add(new BigInteger(operand));
    }
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
