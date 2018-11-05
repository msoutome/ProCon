public class Question
{
    public static void main(String[] args) 
    {
        Question q = new Question();
        Solve s = q.new Solve();
        s.ans();
    }

    private int array[][] =
    { 
        {1,8,0,1,0,1,1},
        {1,1,0,1,0,0,1},
        {0,0,0,1,1,0,1},
        {1,1,0,0,0,0,1},
        {1,1,1,0,1,1,1},
        {0,0,0,0,0,0,0},
        {0,1,0,1,0,1,1},
        {0,0,0,0,0,0,0},
        {1,9,1,1,0,1,0},
    };
    public class Solve
    {
        public void ans()
        {
            int ret = 0;
            Counter cnt = new Counter();
            for(int row = 0; row <array.length;row++)
            {
                for(int col = 0; col <array[row].length;col++)
                {
                    if(array[row][col]==8)
                    {
                        // start
                        ret = func(array, row, col, cnt);
                        break;
                    }
                }
                if(ret>0)
                {
                    // already goaled
                    break;
                }
            }

            if(ret>0)
            {
                System.out.println("Goal Route!!");
                printarray(array);

                // Answer
                System.out.printf("ANS:count[%d]\n",cnt.cnt);
            }else
            {
                System.out.println("ANS:No Goal");
            }
        }

        // stepped counter
        public class Counter
        {
            public int cnt = 0;
        }

        private int func(int[][] m, int row, int col, Counter cnt)
        {
            if(row<0 || m.length<=row)
            {
                // out of area
                return 0;
            }
            if(col<0 || m[row].length<=col)
            {
                // out of area
                return 0;
            }
            if(m[row][col]==1)
            {
                // wall
                return 0;
            }
            if(m[row][col]==2)
            {
                // already stepped
                return 0;
            }
            if(m[row][col]==9)
            {
                // goal
                cnt.cnt++;
                return 1;
            }

            // stepped mark
            m[row][col]=2;

            // step count
            cnt.cnt++;

            int cnt_goal = -1;
            int ret=0;
            int cnt_bk = cnt.cnt;

            //right route
            if(func(m,row,col+1,cnt)>0)
            {
                ret = 1;
                if(cnt_goal==-1 || cnt_goal>cnt.cnt)
                {
                    cnt_goal=cnt.cnt;
                }
            }

            //left route
            cnt.cnt = cnt_bk;
            if(func(m,row,col-1,cnt)>0)
            {
                ret = 1;
                if(cnt_goal==-1 || cnt_goal>cnt.cnt)
                {
                    cnt_goal=cnt.cnt;
                }
            }
            
            //down route
            cnt.cnt = cnt_bk;
            if(func(m,row+1,col,cnt)>0)
            {
                ret = 1;
                if(cnt_goal==-1 || cnt_goal>cnt.cnt)
                {
                    cnt_goal=cnt.cnt;
                }
            }
            
            //up route
            cnt.cnt = cnt_bk;
            if(func(m,row-1,col,cnt)>0)
            {
                ret = 1;
                if(cnt_goal==-1 || cnt_goal>cnt.cnt)
                {
                    cnt_goal=cnt.cnt;
                }
            }
            
            if(cnt_goal != -1)
            {
                // Goal Route
                m[row][col]=3; 
                cnt.cnt = cnt_goal;
            }else
            {
                // No Goal Route
                m[row][col]=0;               
            }

            return ret;
        }

        // for Debug
        private void printarray(int[][] a)
        {
            System.out.println("----------------------");
            for(int row = 0; row<a.length; row++)
            {
                System.out.printf("{");
                for(int col = 0; col<a[row].length; col++ )
                {
                    System.out.printf("%d",a[row][col]);
                    if(col!=a[row].length-1)
                    {
                        System.out.printf(",");
                    }
                }
                System.out.printf("},\n");
            }
            System.out.println("----------------------");
        }
    }
}


