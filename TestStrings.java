import java.util.Arrays;

public class TestStrings {
    public static void main(String[] args) 
    {
        String s1="apple fruit";
        String s2="apple is a fruit";
        System.out.println(reverse_string(s1));
        System.out.println(split_reverse(s2));
        System.out.println(check_anagram("apple", "lepAp"));
        System.out.println(check_anagram("apple fruit", "FRU-IT.lepAp"));
        System.out.println(check_anagram("T.S. Eliot", "toilets"));
        System.out.println(check_anagram("T.S. Eliot", "toiletss"));
        System.out.println(check_panagram("A quick brown fox jumps over the lazy dog"));
        System.out.println(check_panagram("A quick brown fox jumps over the layy dog"));

        System.out.println(mysort("A quick brown fox jumps over the lazy dog"));
        System.out.println(mysort(s2));

        System.out.println(repeated_chars("elephanta"));
        VC_Counter("hello world 1 2");
        System.out.println(SChars("alpha bet 123 #!@"));

    }

    public static String reverse_string(String str)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
        {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String split_reverse(String str)
    {
        String[] strs=str.split(" ");
        for(int i=0;i<strs.length;i++)
        {
            strs[i]=reverse_string(strs[i]);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++)
        {
            sb.append(strs[i]+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static Boolean check_anagram(String str1,String str2)
    {
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)>='A'&& str1.charAt(i)<='Z' || str1.charAt(i)>='a'&& str1.charAt(i)<='z')
            {
                sb2.append(str1.charAt(i));
            }
        }
        str1=sb2.toString();
        sb2.delete(0, sb2.length());
        for(int i=0;i<str2.length();i++)
        {
            if(str2.charAt(i)>='A'&& str2.charAt(i)<='Z' || str2.charAt(i)>='a'&& str2.charAt(i)<='z')
            {
                sb2.append(str2.charAt(i));
            }
        }
        str2=sb2.toString();

        str1=mysort(str1);
        str2=mysort(str2);

        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();

        // Arrays.sort(ch1);
        // Arrays.sort(ch2);

        for(int i=0;i<ch1.length;i++)
        {
            if(ch1[i]!=ch2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static boolean check_panagram(String str)
    {
        if(str.length()<26)
        {
            return false;
        }
        StringBuilder sb3=new StringBuilder(); 
        // removes everything other than characters
        str=str.toLowerCase(); // turned into small case for ease of use
        for(int i=0;i<str.length();i++) // removing spaces
        {
            if(str.charAt(i)>='a'&& str.charAt(i)<='z')
            {
                sb3.append(str.charAt(i));
            }
        }
        str=sb3.toString();
        str=mysort(str);
        //char[] chars=str.toCharArray();
        //Arrays.sort(chars);
        //str=new String(chars);
        int char_start_value=97; // "a" ASCII value
        boolean start=true;
        char ch=' ';
        System.out.println(str);
        for(int i=0;i<str.length();)
        {
            if(char_start_value>122  || ( char_start_value == 121 && str.charAt(i)=='z' )) // 122->"z" , covered all the alphabets
            {   // 2nd case is for last char when alphabets till y are covered and z is remaining at last location
                return true;
            }

            if(start==true)
            {
                if(str.charAt(i)==char_start_value)
                {
                    ch=str.charAt(i);
                    i++;
                    start=false;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(str.charAt(i)==ch)// same value as previous, like aabc
                {
                    i++;
                }
                else // different value to previous, like abbc
                {
                    char_start_value++;
                    if(str.charAt(i)==char_start_value) // when immediately found the next character
                    {
                        ch=str.charAt(i);
                        //System.out.println("CH is updated to "+ch);
                        i++;
                    }
                    else // when immediate alpahbet in sequence is not found
                    {
                        return false;
                    }
                }
            }
        }
        return false; // string ended before covering all alphabets
    }

    public static String repeated_chars(String str)
    {
        StringBuilder sb4=new StringBuilder();
        str=mysort(str);
        char prev='a';
        for(int i=0;i<str.length();i++)
        {
            if(i==0)
            {
                prev=str.charAt(0);
            }
            else
            {
                if(str.charAt(i)==prev)
                {
                    sb4.append(str.charAt(i));
                }
                else
                {
                    prev=str.charAt(i);
                }
            }
        }

        return sb4.toString();
    }

    public static String mysort(String str)
    {
        String outp;
        char[] chars=str.toCharArray();
        for(int i=0;i<str.length();i++)
        {
            char max=chars[0];
            int max_index=0;
            for(int j=0;j<str.length()-i;j++)
            {
                if(max<chars[j])
                {
                    max=chars[j];
                    max_index=j;
                }
                // if(chars[i]<chars[j])
                // {
                //     // swapping
                //     char temp=chars[j];
                //     chars[j]=chars[i];
                //     chars[i]=temp;
                // }
            }
            // need to swap (last but x) and the max items
            chars[max_index]=chars[chars.length-1-i];
            chars[chars.length-1-i]=max;
        }
        return new String(chars);
    }

    public static void VC_Counter(String str)
    {
        str=str.toLowerCase();
        int vowels=0;
        int consonants=0;
        for(int i=0;i<str.length();i++)
        {
            if(Character.isAlphabetic(str.charAt(i)))
            {
                if( str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' )
                {
                    vowels++;
                }
                else
                {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels : "+vowels+" , Consonants : "+consonants);
    }

    public static int SChars(String str)
    {
        StringBuilder sb5=new StringBuilder();
        str=str.replaceAll(" ", "");
        int counter=0;
        for(int i=0;i<str.length();i++)
        {
            if(!(Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i))))
            {
                counter++;
            }
        }
        return counter;
    }
    
}
