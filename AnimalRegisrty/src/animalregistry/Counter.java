package animalregistry;

public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;
    private boolean usedInTry = false;

    public void markUsedInTry() {
        usedInTry = true;
    }

    public void add() {
        if (closed) {
            throw new IllegalStateException("Ресурс закрыт.");
        }
        if (!usedInTry) {
            throw new IllegalStateException("Счётчик должен использоваться внутри блока try-with-resources.");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        if (!usedInTry) {
            throw new IllegalStateException("Счётчик не был использован внутри блока try-with-resources.");
        }
        closed = true;
    }
}
