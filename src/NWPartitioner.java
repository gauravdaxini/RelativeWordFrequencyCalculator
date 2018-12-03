import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class NWPartitioner extends Partitioner<NextWord, IntWritable> {
    @Override
    public int getPartition(NextWord twoWords, IntWritable intWritable, int numPartitions) {
        return (twoWords.getWord().hashCode() & Integer.MAX_VALUE ) % numPartitions;
    }
}