/*
時系列に並べられたN個の価格によって得られる最大の利益
*/

public class Main
{
    public static void main(String[] args) 
    {
        Main m = new Main();
        Question q = m.new Question();
        q.ans1();
        q.ans2();
    }

    static final int historical_price[] = {5,6,7,8,9,2,3,6,7,5};

    public class Question
    {

        public void ans1()
        {
            int max_gain = Integer.MIN_VALUE;
            for(int i=1;i<historical_price.length;i++)
            {
                for(int j=0;j<i;j++)
                {
                    max_gain = Math.max(max_gain,historical_price[i]-historical_price[j]);
                }
            }
            System.out.printf("ans1:max=[%d]\n",max_gain);
        }

        public void ans2()
        {
            int max_gain = Integer.MIN_VALUE;
            int min_price = Integer.MAX_VALUE;
            for(int i=1;i<historical_price.length;i++)
            {
                min_price = Math.min(min_price,historical_price[i-1]);
                max_gain = Math.max(max_gain,historical_price[i]-min_price);
            }
            System.out.printf("ans2:max=[%d]\n",max_gain);
        }
    }
}


