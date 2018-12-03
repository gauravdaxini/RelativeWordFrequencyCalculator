import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TempComparator extends WritableComparator {
	protected TempComparator() {
        super(DoubleWritable.class, true);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public int compare(WritableComparable first, WritableComparable second) {
        DoubleWritable one = (DoubleWritable) first;
        DoubleWritable two = (DoubleWritable) second;          
        return one.compareTo(two) * -1;
    }
}