
class Buffer {
  private Object[] buffer;
  private int start;
  private int end;
  private int size;

  Buffer(int n) {
    buffer = new Object[n];
  }

  synchronized void produce(Object o) {
    while (size == n) {
      wait();
    }
    buffer[end] = o;
    end = (end + 1) % n;
    size++;
    notifyAll();
  }

  synchronized Object consume() {
    while (size == 0) {
      wait();
    }
    Object temp = buffer[start];
    start = (start + 1) % n;
    size--;
    notifyAll();
    return temp;
  }
}

Buffer b = new Buffer();

10.times {
  Thread.start {  // Producer
    b.produce(new Random().nextInt(100));
  }
}

10.times {
  Thread.start {  // Consumer
    b.consume();
  }
}