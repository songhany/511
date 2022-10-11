import java.util.concurrent.Semaphore

Semaphore s = new Semaphore(1)  // this mutex is [1, set{}]  where 1 is number of permit, {} is a set. 
// Semaphore mutex = new Semaphore(1, true)  // this mutex is [1, queue]  guarantee first-in first-out granting of permits under contention


Thread.start {
  s.acquire()
  print "a"
  print "b"
  s.release()

}

Thread.start {
  s.acquire()
  print "c"
  print "d"
  s.release()
}