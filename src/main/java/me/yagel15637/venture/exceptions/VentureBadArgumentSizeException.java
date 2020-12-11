package me.yagel15637.venture.exceptions;

/**
 * @author Reap
 */
public class VentureBadArgumentSizeException extends VentureIllegalArgumentException {
    public VentureBadArgumentSizeException() { this(""); }
    public VentureBadArgumentSizeException(String message) { super(message); }
}
