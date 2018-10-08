public class Question
{
    public static void main(String[] args) 
    {
        Question q = new Question();
        Solve s = q.new Solve();
        s.ans();
    }

    final String targetstr = "NAGANOKANAGAWATOKYONAGANOKANAZAWAAOMORINAGANOTOKYO";
    final String findstr = "NAGANO";
    public class Solve
    {
        public void ans()
        {
            int count = 0;
            int index = 0;
            String str = targetstr;

            for(;;)
            {
                str = str.substring(index);
                index = str.indexOf(findstr);
                if(index == -1)
                {
                    break;
                }else
                {
                    index += findstr.length();
                    count++;
                }
            }
            System.out.println("ANS:"+count);
        }
    }
}


