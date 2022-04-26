package DoorsAndLocks;
import java.util.*;

public class Keychain {
    private HashMap<Keyshape, ArrayList<Key>> keys = new HashMap<Keyshape, ArrayList<Key>>();

    public Keychain() {};

    public Keychain(Collection<Key> keys) {
        for (Key k : keys) {
            addKey(k);
        }
    }

    public boolean addKey(Key key) {
        if (!keys.containsKey(key.shape())) keys.put(key.shape(), new ArrayList<Key>());
        keys.get(key.shape()).add(key);
        return true;
    }

    public boolean removeKey(Key key) {
        if (keys.containsKey(key.shape())) return keys.get(key.shape()).remove(key);
        return false;
    }

    public int keyCount() {
        int keyCount = 0;
        for (Keyshape keyshape : keys.keySet()) {
            keyCount += keys.get(keyshape).size();
        }
        return keyCount;
    }

    public boolean lock(Door door) {
        if (door.isLocked()) return true; // it's already locked!
        if (!door.hasKey()) return false; // cannot be locked
        if (!keys.containsKey(door.key().shape())) return false; // don't have this shape of key
        for (Key k : keys.get(door.key().shape())) {
            if (door.lock(k)) return true; // successfully locked!
        }
        return false; // no matching keys on the keychain, couldn't lock.
    }

    public boolean unlock(Door door) {
        if (!door.isLocked()) return true; // it's already unlocked!
        if (!door.hasKey()) return true; // cannot unlocked because it can't be locked
        if (!keys.containsKey(door.key().shape())) return false; // don't have this shape of key
        for (Key k : keys.get(door.key().shape())) {
            if (door.unlock(k)) return true; // successfully unlocked!
        }
        return false; // no matching keys on the keychain, couldn't unlock.
    }
}
