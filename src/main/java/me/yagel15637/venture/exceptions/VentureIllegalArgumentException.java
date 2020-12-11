package me.yagel15637.venture.exceptions;

/**
 * @author Reap
 */
public class VentureIllegalArgumentException extends VentureException {
    public VentureIllegalArgumentException() { this(""); }
    public VentureIllegalArgumentException(String message) { super(message); }
}
