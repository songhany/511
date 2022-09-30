import java.util.concurrent.Semaphore

Semaphore mutex = new Semaphore(1)
Semaphore b = new Semaphore(0)

c = 0

P = Thread.start {
  10.times {
    mutex.acquire()
    c++;
    mutex.release()
  }
  b.release()
}

Q = Thread.start {
  10.times {
    mutex.acquire()
    c++
    mutex.release()
  }
  b.release()
}

// wait for P and Q to finish
b.acquire()
b.acquire()
println c
