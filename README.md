
# Image Processing with Java

A program that applies a grayscale filters to multiple images using the average method.

## What I learned and utilized

- Strong grasp and application of OOP principles: encapsulation, inheritance, polymorphism, and abstraction.
- Implementation of Producer-Consumer model with multithreading, synchronization, and detailed console communication.
- Communication via Pipes with segmented data transmission.

## Implementation requirements

1. The source image is a BMP file - 24-bit BMP - RGB

2. Only low-level algorithms and/or code sequences are used for processing (the use of processing methods other than those specified in the assignment is not accepted)

3. Fully include the concepts of OOP - encapsulation, inheritance, polymorphism, abstraction

4. The source code complies with all "Coding standards". The source code is commented

5. File operations

6. Input operations from the keyboard and through command-line parameters for assigning input files, parameters/settings/execution options, and for assigning output files

7. The application must be multi-modular (division into classes with hierarchies - even at the cost of processing time). At least 3 levels of inheritance

8. Include varargs

9. Include constructors

10. Include at least one initialization block and one static initialization block

11. Include Interface (with a class that implements it)

12. Include Abstract Classes with abstract methods and concrete classes that extend abstract classes

13. Include exception handling

14. The application contains 2 packages: Package 1 contains the test application, package 2 contains the rest of the classes

15. The application contains Producer-Consumer with the following requirements:
a. A new thread is allocated for reading from the source image file - Producer Thread. It enters Not Runnable after reading a segment of information

b. A new thread (Consumer Thread) is allocated for consuming the information provided by the Producer Thread. "Multithread communication" (notify) is used.

c. Output is inserted into the console and sleep (1000) is used to highlight the communication steps.

d. Synchronization elements are used to protect against interference with other possible threads

e. After consuming the entire source image information, processing begins

16. The application contains communication through Pipes with the following requirements:
a. Consumer uses a Pipe to transmit the processed image to an object of type WriterResult

b. Transmission through the pipe is done by partitioning the information into 4 segments.

c. At the transmission of each segment, a message is sent to the console

d. At the reception of each segment, a message is sent to the console

e. The result is deposited in a file
