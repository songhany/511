
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
    notify();  // why only use notify() could cause deadlock ?
  }

  synchronized Object consume() {
    while (buffer == null) {
      wait();
    }
    Object temp = buffer;
    buffer = null;
    notify();  // why only use notify() could cause deadlock ?
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