public class App 
{
    public static void main(String[] args) throws Exception 
    {
        int length=11;
        for(int i=0;i<length;i++)
        {
            for(int j=0;j<length;j++)// I
            {
                if(i==0 || i==length-1)
                {
                    System.out.print("*");
                }
                else if(i>0 && i<length-1)
                {
                    if(j==length/2)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("   ");
            for(int j=0;j<length;j++)// N
            {
                if(j==0 || j==length-1 || i==j)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");
            for(int j=0;j<length;j++)// E
            {
                if(i==0 || i==length/2 || i==length-1 || j==0) 
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");
            for(int j=0;j<length;j++)// U
            {
                if(j==0 && i<length-2 || j==length-1 && i<length-2 || (i>length-2 && j<length-2)&&j>=2 || i==length-2 && j==1 || i==length-2 && j==length-2)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");
            for(int j=0;j<length;j++)// R
            {
                if(((i==0 || i==(length/2)) && j<length-4 ) || ((i<(length/2)-1&& i>1)  && j==length-2) || j==0 || i-j+1==(length/2) || (i==1 && j==length-3) || (i==(length/2)-1 && j==length-3))
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");
            for(int j=0;j<length;j++)// O
            {
                if( (i>1 && i<length-2) && (j==0 || j==length-1) || (i==0 || i==length-1) && (j>1 && j<length-2) || (i==1||i==length-2)&&(j==1 || j==length-2)   )
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");
            for(int j=0;j<length;j++)// N
            {
                if(j==0 || j==length-1 || i==j)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");
            System.out.println(" ");
        }
        // numbers

        int count=5;
        int value=1;
        for(int i=0;i<count;i++)
        {
            for(int j=0;j<count;j++)
            {
                System.out.print(value);
            }
            System.out.println();
            value++;
        }

        // patterns
        int new_length=12;
        for(int i=0;i<new_length;i++)
        {
            for(int j=0;j<new_length;j++)
            {
                if(j==0 || j==new_length-1 || i>new_length/2&&j==new_length ||j-i>=(new_length-1)/2||i+j<6)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }

            System.out.print("   ");

            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=0;j<(new_length-i-1)*2;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }

            System.out.print("   ");

            for(int j=1;j<=new_length;j++)
            {
                if(i==0 || j==1  || i==new_length-1 || i+j<(new_length/2)+2 || i-j>(new_length/2)-2)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }

            System.out.println(" ");
        
        }
        
    }
}

