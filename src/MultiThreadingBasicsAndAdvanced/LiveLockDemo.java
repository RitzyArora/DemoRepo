package MultiThreadingBasicsAndAdvanced;

public class LiveLockDemo {
   public  static class Resource{
        private String name;
        private boolean locked=false;

        public Resource(String name) {
            this.name = name;
        }

        public synchronized boolean tryLock(){
            if(!locked)
            {
                locked=true;
                return true;
            }
            return false;
        }

        public synchronized void unlock(){
            locked=false;
        }
        public String getName(){
            return name;
        }
    }
}
