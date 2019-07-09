import java.io.*;
import java.util.*;
class HE_Sample_java
{
    static Scanner sc;
    static PrintWriter out;
    static int[] arr;
    static long[] pre;
    static boolean[] v;
    static int maxn=1000003;

    static void init() throws Exception
    {
        sc=new Scanner(System.in);
        out=new PrintWriter(System.out);
    }

    static void mark(int num,int max)
    {
        int i=2,elem;
        while((elem=(num*i))<=max)
        {
            arr[elem-1]=1;
            i++;
        }
    }

    static void build()
    {
        arr=new int[maxn];
        v=new boolean[maxn];
        for(int i=1;i<maxn-1;i++)
        {
            if(arr[i]==0)
            {
                mark(i+1,maxn-1);
                v[i+1]=true;
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        init();
        build();
        pre=new long[maxn];
        for(int i=1;i<maxn;i++)
        {
            long val=(v[i])?i:0;
            pre[i]=pre[i-1]+val;
        }
        int n=sc.nextInt();
        while(n>0)
        {
            int l=sc.nextInt(),r=sc.nextInt();
            long ans=pre[r]-pre[l-1];
            out.println(ans);
            n--;
        }
        out.close();
    }
}