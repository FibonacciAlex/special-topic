/**
 * Example class - implements Serializable
 */

import java.io.Serializable;

public class Example implements Serializable {
    private static final long serialVersionUID = 1L;
    private int mIntValue;
    private float mFloatValue;
    Example(int i, float f) {
        mIntValue = i;
        mFloatValue = f;
    }

    public String toString() {
        return "Integer = " + mIntValue + "; Float = " + mFloatValue;
    }
}
