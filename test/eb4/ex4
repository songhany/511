import java.util.concurrent.Semaphore;

Semaphore settingXY = new Semaphore(1);

int y = 0
int z = 0


Thread.start { // Q
  settingXY.acquire()
  y = 1
  z = 2
  settingXY.release()
}


Thread.start { // P
  settingXY.acquire()
  int x
  x = y + z
  println "x = " + x
  settingXY.release()
}