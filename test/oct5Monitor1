
class Buffer {
  private Object buffer;

  Buffer() {
    buffer = null;
  }

  synchronized void produce(Object o) {
    while (buffer != null) {
      wait();
    }
    buffer = o;
    notify();  // why only use notify() possibly cause deadlock ? end up both Consumer and Producer wait()
  }

  synchronized Object consume() {
    while (buffer == null) {
      wait();
    }
    Object temp = buffer;
    buffer = null;
    notify();  // why only use notify() possibly cause deadlock ? end up both Consumer and Producer wait()
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