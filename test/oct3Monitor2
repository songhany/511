
class Ctr {

  private int c;

  Ctr(int init) {
    c = init;
  }

  public void inc() {
    m()
    syncrhonized (this) { c++; }  // syncrhonized for which Object? for this object
  }

  public synchronized void dec() {
    m()
    c--;
  }

  public synchronized int read() {
    return c;
  }
}

Ctr c = new Ctr(0)

P = Thread.start {
  10.times {
    c.inc()
  }
}

Q = Thread.start {
  10.times {
    c.inc()
  }
}

P.join()
Q.join()
println c.read()