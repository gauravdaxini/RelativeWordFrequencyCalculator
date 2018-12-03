## Relative Word Frequency Calculator

This project is written in Java using Map Reduce approach which will calculate the relative word frequencies in an input document. Here, we have taken 100K Wiki documents in a single file and project uses a pair of mapper and reducer along with a partitioner.

### Pre-Requisite
- [Java installed](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04) on the machine.
- [Hadoop installed](https://www.digitalocean.com/community/tutorials/how-to-install-hadoop-in-stand-alone-mode-on-ubuntu-16-04) on the machine.
- [Eclipse](http://www.eclipse.org/downloads/packages/release/2018-09/r/eclipse-ide-java-ee-developers) installed on the machine.

### Build Dependencies
Add the following libraries in the projects build path.
- [Hadoop Core](https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-core)
- [Apache Commons CLI](https://mvnrepository.com/artifact/commons-cli/commons-cli)

### Create Project Archive
Export the java project as a Jar File.

### Run

Please refer the settings.txt and commands.txt file to run the program on Hadoop System.