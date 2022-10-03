
class Buffer {
  Object buffer;

  Buffer() {
      buffer = null;
  }
  
  synchronized void produce(Object o) {
    while (buffer != null) {
      wait();  // release the lock
    }
    buffer = o;
    notifyAll();  // wake all up, put all threads in runable state
  }

  synchronized Object consume() {
    while (buffer == null) {
      wait();
    }
    Object temp = buffer;
    buffer = null;
    notifyAll();
    return temp;
  }
}

Buffer b = new Buffer()

10.times {
  int id = it
  Thread.start {  // Producer
    b.produce( new Random().nextInt(100))
    println "$id: produced"
  }
}

10.times {
  int id = it
  Thread.start {  // Consumer
    b.consume()
    println "$id: consumed"
  }
}



