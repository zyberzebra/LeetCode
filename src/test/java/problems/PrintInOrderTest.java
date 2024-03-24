package problems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PrintInOrderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void changeSystemOutputStream() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @RepeatedTest(value = 10)
    void printInOrder() throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
        Thread first = createThread(printInOrder::first, () -> System.out.print("first"));
        Thread second = createThread(printInOrder::second, () -> System.out.print("second"));
        Thread third = createThread(printInOrder::third, () -> System.out.print("third"));
        List<Thread> threadList = randomize(third, second, first);

        // when
        threadList.forEach(Thread::start);

        // then
        waitForThreads(threadList);
        assertThat(outputStreamCaptor).hasToString("firstsecondthird");
    }

    private interface PrintInOrderRunnableMethod {

        void run(Runnable runnable) throws InterruptedException;
    }
    private static Thread createThread(PrintInOrderRunnableMethod method, Runnable runnable) {
        return new Thread(() -> {
            try {
                method.run(runnable);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static List<Thread> randomize(Thread thread3, Thread thread2, Thread thead1) {
        List<Thread> threadList = new ArrayList<>(List.of(thread3, thread2, thead1));
        Collections.shuffle(threadList);
        return threadList;
    }

    private static void waitForThreads(List<Thread> threadList) throws InterruptedException {
        for (Thread thread : threadList) {
            thread.join();
        }
    }
}