package DoorsAndLocks;

import java.util.*;

public class Warehouse {
    public Set<Door> doors = new TreeSet<Door>();

    public Warehouse() {
        int i = 0;
        for (; i < 10; i++) {
            Door d = new Door(null);
            doors.add(d);
        }
        for (; i < 100; i++) {
            int num = (int)Math.random() * 4;
            Keyshape shape;

            switch (num) {
                case 0:
                    shape = Keyshape.Square;
                    break;
                case 1:
                    shape = Keyshape.Circular;
                    break;
                case 2:
                    shape = Keyshape.Oval;
                    break;
                case 3:
                    shape = Keyshape.TrapezoidDown;
                    break;
                default:
                    shape = Keyshape.Square;
            }

            Key k = new Key(shape);
            Door d = new Door(k);
            doors.add(d);
        }
    }
}
