import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RelativeFrequencyCalculator {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration config1 = new Configuration();
		Job job1 = Job.getInstance(config1);
		job1.setJarByClass(RelativeFrequencyCalculator.class);
		job1.setJobName("RFCJob1");
		job1.setMapperClass(RFCMapper1.class);
		job1.setReducerClass(RFCReducer1.class);
        job1.setCombinerClass(NWReducer.class);
        job1.setPartitionerClass(NWPartitioner.class);
		job1.setOutputKeyClass(NextWord.class);
		job1.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job1, new Path(args[0]));
		FileOutputFormat.setOutputPath(job1, new Path("tempOutput"));
		job1.setNumReduceTasks(3);
		job1.waitForCompletion(true);
		
		Configuration config2 = new Configuration();
		Job job2 = Job.getInstance(config2);
		job2.setJarByClass(RelativeFrequencyCalculator.class);
		job2.setJobName("RFCJob2");
		job2.setMapperClass(RFCMapper2.class);
		job2.setReducerClass(RFCReducer2.class);
  	  	job2.setSortComparatorClass(TempComparator.class);
		job2.setOutputKeyClass(DoubleWritable.class);
		job2.setOutputValueClass(NextWord.class);
		FileInputFormat.addInputPath(job2, new Path("tempOutput"));
		FileOutputFormat.setOutputPath(job2, new Path(args[1]));
		job2.setNumReduceTasks(1);
		System.exit(job2.waitForCompletion(true) ? 0 : 1);
	}
}