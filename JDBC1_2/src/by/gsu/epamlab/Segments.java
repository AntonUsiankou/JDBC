package by.gsu.epamlab;

public class Segments {
    private int len;
    private int num;

    public Segments(int len, int num) {
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
        return  len + ";" + num;
    }
}
