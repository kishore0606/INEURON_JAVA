import java.util.Scanner;

public class App {
    static int tar=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Menu :");
            System.out.println("---------------------------------------------");
            System.out.println("1. Start game / Reset game");
            System.out.println("2. Try again");
            System.out.println("3. Exit game");
            System.out.println(" ");
            System.out.println("Enter the option :");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:     
                    System.out.println("Enter the target value :");
                    int target=sc.nextInt();
                    tar=target;
                    System.out.println("How many players want to play the game ?");
                    int players_count=sc.nextInt();
                    int[] players=new int[players_count];
                    String outp="";
                    int count_players=0;
                    for(int i=0;i<players_count;i++)
                    {
                        System.out.println("Enter player "+(i+1)+" guess :");
                        players[i]=sc.nextInt();
                        if(players[i]==target)
                        {
                            outp=outp+" player"+(i+1)+" ,";
                            count_players++;
                        }
                    }
                    if(count_players==0)
                    {
                        System.out.println("No players guessed the target right.");
                    }
                    else if(count_players>0 && count_players<players_count)
                    {
                        System.out.println("Game Tied between "+outp.substring(0,outp.length()));
                    }
                    else if(count_players==players_count)
                    {
                        System.out.println("Game Tied among all players.");
                    }
                    break;
                case 2:
                    int target1=tar;
                    if(tar==Integer.MAX_VALUE)
                    {
                        System.out.println("No previouos games found, Kindly enter new value.");
                        System.out.println("Enter the target value :");
                        target1=sc.nextInt();
                    }
                    System.out.println("How many players want to play the game :");
                    int players_count1=sc.nextInt();
                    int[] players1=new int[players_count1];
                    String outp1="";
                    int count_players1=0;
                    for(int i=0;i<players_count1;i++)
                    {
                        System.out.println("Enter player "+(i+1)+" guess :");
                        players1[i]=sc.nextInt();
                        if(players1[i]==target1)
                        {
                            outp1=outp1+" player"+(i+1)+" ,";
                            count_players1++;
                        }
                    }
                    if(count_players1==0)
                    {
                        System.out.println("No players guessed the target right :");
                    }
                    else if(count_players1>0 && count_players1<players_count1)
                    {
                        System.out.println("Game Tied between "+outp1.substring(0,outp1.length()-1));
                    }
                    else if(count_players1==players_count1)
                    {
                        System.out.println("Game Tied among all players.");
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Enter valid option.");
                    break;     
            }
        }
    }
}
