package by.gsu.epamlab;

import static by.gsu.epamlab.Constants.DELIMITER;

public class LenNum {
    private final int len;
    private int num;

    public LenNum(int len, int num) {
        this.len = len;
        this.num = num;
    }

    public int getLen() {
        return len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return  len + DELIMITER + num;
    }
}
