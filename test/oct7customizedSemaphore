// use synchronized to write your customize Semaphore

class Sem {
  private int permits;

  Sem(int init) {
    permits = init;
  }

  synchronized acquire() {
    while (permits == 0) {
      wait();
    }
    permits--;
  }

  synchronized release() {
      permits++;
      notify();
  }
}

Sem mutex = new Sem(1)
c = 0
P = Thread.start {
  10.times {
    mutex.acquire()
    c++
    mutex.release()
  }
}

Q = Thread.start {
  10.times {
    mutex.acquire()
    c++
    mutex.release()
  }
}

P.join()
Q.join()
println c