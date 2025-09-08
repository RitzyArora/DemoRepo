package MultiThreadingBasicsAndAdvanced;

public class RoundRobinSchedulingDemo{
    public static final class RRTask{
        final String name;
        public int remainingUnits;

        public RRTask(String name, int remainingUnits) {
            this.name = name;
            this.remainingUnits = remainingUnits;
        }
        public void runQueue(int quantum){
            int run=Math.min(quantum,remainingUnits);
            for(int i=0;i<run;i++)
            {
                busyWork();}
                remainingUnits-=run;
                System.out.println("Task"+name+"ran for"+run+"remaining units are "+remainingUnits);

        }
        static void busyWork(){
            double x=0;
            for(int i=0;i<1000;i++)
                x+=Math.sqrt(i);
        }
    }
}
