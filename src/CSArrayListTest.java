/**
 * A dependency-free test runner. Run main() and inspect the printed results.
 */
public class CSArrayListTest {

    private static int passed;
    private static int failed;

    public static void main(String[] args) {
        runTest("new list is empty", CSArrayListTest::newListIsEmpty);
        runTest("append", CSArrayListTest::appendsValues);
        runTest("indexed insertion", CSArrayListTest::insertsValueAtIndex);
        runTest("removal", CSArrayListTest::removesAndReturnsValue);
        runTest("resizing", CSArrayListTest::preservesValuesWhenArrayGrows);
        runTest("invalid index", CSArrayListTest::getRejectsInvalidIndex);

        System.out.println();
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

        if (failed > 0) {
            throw new AssertionError(failed + " test(s) failed");
        }
    }

    private static void newListIsEmpty() {
        CSArrayList<String> list = new CSArrayList<>();
        checkEquals(0, list.size());
        checkTrue(list.isEmpty());
    }

    private static void appendsValues() {
        CSArrayList<String> list = new CSArrayList<>();
        list.add("A");
        list.add("B");

        checkEquals(2, list.size());
        checkEquals("A", list.get(0));
        checkEquals("B", list.get(1));
    }

    private static void insertsValueAtIndex() {
        CSArrayList<String> list = new CSArrayList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");

        checkEquals("A", list.get(0));
        checkEquals("B", list.get(1));
        checkEquals("C", list.get(2));
    }

    private static void removesAndReturnsValue() {
        CSArrayList<String> list = new CSArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        checkEquals("B", list.remove(1));
        checkEquals(2, list.size());
        checkEquals("A", list.get(0));
        checkEquals("C", list.get(1));
    }

    private static void preservesValuesWhenArrayGrows() {
        CSArrayList<Integer> list = new CSArrayList<>();
        for (int value = 0; value < 10; value++) {
            list.add(value);
        }

        checkEquals(10, list.size());
        for (int value = 0; value < 10; value++) {
            checkEquals(value, list.get(value));
        }
    }

    private static void getRejectsInvalidIndex() {
        CSArrayList<String> list = new CSArrayList<>();
        try {
            list.get(0);
        } catch (IndexOutOfBoundsException expected) {
            return;
        }
        throw new AssertionError("Expected IndexOutOfBoundsException");
    }

    private static void runTest(String name, Runnable test) {
        try {
            test.run();
            passed++;
            System.out.println("PASS: " + name);
        } catch (AssertionError | RuntimeException error) {
            failed++;
            System.out.println("FAIL: " + name + " - " + error.getMessage());
        }
    }

    private static void checkTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected true but was false");
        }
    }

    private static void checkEquals(Object expected, Object actual) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError("Expected " + expected + " but was " + actual);
        }
    }
}
