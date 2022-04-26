package DoorsAndLocks;
import java.util.UUID;

public class Key implements Cloneable, Comparable<Key> {
    private UUID key;
    private Keyshape shape = Keyshape.Unknown;

    // default constructor
    public Key() {
        key = UUID.randomUUID();
    }

    public Key(Keyshape shape) {
        this(); // invokes default constructor
        this.shape = shape;
    }

    // copy constructor
    public Key(Key original) {
        key = original.key;
        shape = original.shape;
    }

    public Keyshape shape() {
        return shape;
    }

    @Override public Object clone() {
        return new Key(this);
    }

    @Override public String toString() {
        return "Key [key=" + key + "]";
    }

    @Override public boolean equals(Object obj) {
        if (!getClass().isInstance(obj)) return false;
        Key other = (Key)obj;
        return key.equals(other.key);
    }

    @Override public int hashCode() {
        return key.hashCode();
    }

    @Override public int compareTo(Key o) {
        return key.compareTo(o.key);
    }
}

