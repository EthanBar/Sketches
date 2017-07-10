package Cylinder;


public class Vec3 {

    private byte[] val;

    Vec3 () {
        val = new byte[]{0, 0, 0};
    }

    Vec3 (byte x, byte y, byte z) {
        val = new byte[]{x, y, z};
    }

    // Get/Set other

    public void set (byte x, byte y, byte z) {
        this.val = val;
    }

    public byte[] get() {
        return val;
    }

    // Get/Set individual axis

    public byte x() {
        return val[0];
    }

    public byte y() {
        return val[1];
    }

    public byte z() {
        return val[2];
    }

    public void x(byte x) {
        val[0] = x;
    }

    public void y(byte y) {
        val[1] = y;
    }

    public void z(byte z) {
        val[2] = z;
    }
}
