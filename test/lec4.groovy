import java.util.concurrent.Semaphore

Semaphore mutex = new Semaphore(1)  // this mutex is [1, set{}]  where 1 is number of permit, {} is a set. 
// Semaphore mutex = new Semaphore(1, true)  // this mutex is [1, queue]  guarantee first-in first-out granting of permits under contention

int count = 0
P = Thread.start {
  10.times {
    mutex.acquire()
    count = count + 1;
    mutex.release()
  }
}

Q = Thread.start {
  10.times {
    mutex.acquire()
    count = count + 1;
    mutex.release()
  }
}

P.join()
Q.join()
println count
