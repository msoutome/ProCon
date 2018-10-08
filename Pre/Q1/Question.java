public class Question
{
    public static void main(String[] args) 
    {
        Question q = new Question();
        Solve s = q.new Solve();
        s.ans();
    }

    public class Solve
    {
        public void ans()
        {
            int sum = 0;
            for(int i = 5; i<=100; i++)
            {
                int m = i % 5;
                if(m == 2 || m == 4)
                {
                    System.out.println("["+i+"]");
                    sum += i;
                }
            }
            System.out.printf("Ans:[%d]\n",sum);
        }
    }
}


