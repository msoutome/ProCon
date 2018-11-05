/*
きつね蕎麦:650円
山菜蕎麦:780円
かも南蛮蕎麦:980円
20万円でおつりなし
一番多くたべられる組み合わせは？
*/

public class Main
{
    public static void main(String[] args) 
    {
        Main m = new Main();
        Question q = m.new Question();
        q.ans();
    }


    public class Question
    {
        public void ans()
        {
            int init_money = 200000;
            int change_a = init_money;
            int change_b = init_money;
            int change_c = init_money;
            int soba_a = 650;
            int soba_b = 780;
            int soba_c = 980;
            int num_a = 0;
            int num_b = 0;
            int num_c = 0;
            boolean justflg = false;

            for(num_a = init_money / soba_a; num_a>=0; num_a--)
            {
                change_a = init_money;
                change_a -= num_a*soba_a;
                if(change_a<0)
                {
                    continue;
                }else
                if(change_a == 0)
                {
                    justflg = true;
                    break;
                }
                if(change_a>=soba_b)
                {
                    for(num_b = change_a / soba_b; num_b>=0; num_b--)
                    {
                        change_b = change_a;
                        change_b -= num_b*soba_b;
                        if(change_b<0)
                        {
                            continue;
                        }else
                        if(change_b == 0)
                        {
                            justflg = true;
                            break;
                        }
                        if(change_b >= soba_c)
                        {
                            for(num_c = change_b / soba_c; num_c>=0; num_c--)
                            {
                                change_c = change_b;
                                change_c -= num_c*soba_c;
                                if(change_c<0)
                                {
                                    continue;
                                }else
                                if(change_c == 0)
                                {
                                    justflg = true;
                                    break;
                                }
                            }
                            if(justflg)
                            {
                                break;
                            }    
                        }
                    }
                    if(justflg)
                    {
                        break;
                    }    
                }
            }

            if(justflg)
            {
                System.out.printf("650*[%d],780*[%d],980*[%d]\n",num_a,num_b,num_c);
            }else
            {
                System.out.println("No Answer!!");
            }

        }
    }
}


