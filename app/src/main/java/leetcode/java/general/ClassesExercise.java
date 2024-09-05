package leetcode.java.general;


import java.util.ArrayList;
import java.util.List;

class Sequence {
    private int start;
    private int end;

    public Sequence() {
    }

    public Sequence(int i) {
        this.start = i;
        this.end = i;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean Contains(int i) {
        return start <= i && end >= i;
    }

    public boolean isJustAfter(int i) {
        return i == end + 1;
    }

    public boolean isJustBefore(int i) {
        return i == start - 1;
    }
}

class DenseArray {

    private List<Sequence> values;

    public DenseArray() {
        values = new ArrayList<Sequence>();
    }

    public void insert(int i) {
        boolean foundIt = false;
        for (Sequence s : values) {
            if (s.Contains(i)) {
                foundIt = true;
                break;
            } else if (s.isJustAfter(i)) {
                s.setEnd(i);
                break;
            } else if (s.isJustBefore(i)) {
                s.setStart(i);
                break;
            }
        }

        if (!foundIt) {
            Sequence s = new Sequence(i);
            values.add(s);
        }
    }

    public boolean test(int i) {
        for (Sequence s : values) {
            if (s.Contains(i)) {
                return true;
            }
        }
        return false;
    }

    public class LowestUnackedCalculator {

        private DenseArray ackStream;

        public LowestUnackedCalculator() {
            ackStream = new DenseArray();
        }

        public void Insert(int i) {
            ackStream.insert(i);
        }


        public int LowestNotInserted() {
            int clock = 0;

            while (ackStream.test(clock)) { //check if the value exists
                clock++;
            }
            return clock;
        }
    }
}

// Example of usage:
//
// LowestUnackedCalculator luc = new LowestUnackedCalculator();
// luc.Acknowledge(2);
// luc.Acknowledge(0);
// luc.Acknowledge(1);
// luc.LowestUnacked(); // should return 3
// luc.Acknowledge(3);
// luc.LowestUnacked(); // should return 4
// luc.Acknowledge(5);
// luc.LowestUnacked(); // should return 4
// luc.Acknowledge(6);
// luc.LowestUnacked(); // should return 4
// luc.Acknowledge(4);
// luc.LowestUnacked(); // should return 7
//
// Example #2
//
// LowestUnackedCalculator luc = new LowestUnackedCalculator();
// luc.Insert(0);
// luc.Insert(1);
// luc.Insert(3);
// luc.LowestNotInserted(); // should return 2


