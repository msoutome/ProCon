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
        {1,1,0,1,0,1,1},
        {1,1,0,1,0,0,1},
        {0,0,0,1,1,0,1},
        {1,1,0,0,1,0,1},
        {1,1,1,0,0,0,0},
        {0,0,0,0,0,1,1},
        {1,1,1,1,0,1,1},
    };
    public class Solve
    {
        public void ans()
        {
            int minblock = -1;
            int mincount = 0;
            for(int row = 0; row <array.length;row++)
            {
                for(int col = 0; col <array[row].length;col++)
                {
                    if(array[row][col]==1)
                    {
                        int count = func(array, row,col,0);
                        printarray(array);
                        System.out.printf("count[%d]\n",count);
                        if(count==0)
                        {
                            continue;
                        }else
                        if(minblock==-1)
                        {
                            minblock=count;
                            mincount=1;
                        }else
                        if(count<minblock)
                        {
                            minblock=count;
                            mincount=1;
                        }else
                        if(minblock==count)
                        {
                            mincount++;
                        }
                    }
                }
            }
            System.out.printf("ANS:minblock size[%d],count[%d]\n",minblock,mincount);
        }

        // 四方が1なら２に変更する。1が四方にない場合は戻る
        private int func(int[][] m, int row, int col,int count)
        {
            if(row<0 || m.length<=row)
            {
                return count;
            }
            if(col<0 || m[row].length<=col)
            {
                return count;
            }
            if(m[row][col]!=1)
            {
                return count;
            }

            //自分が1である
            m[row][col]=2;
            count++;
            //右
            count=func(m,row,col+1,count);
            //左
            count=func(m,row,col-1,count);
            //下
            count=func(m,row+1,col,count);
            //上
            count=func(m,row-1,col,count);          

            return count;
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


