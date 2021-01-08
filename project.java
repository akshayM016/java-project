class parking
{
    int a[] = new int[10];
    
    int posx=0;
    void add(int x[], int pos)
    {
        this.a=x;
        this.posx=pos;
        if(a[posx-1]==0)
        {
       a[posx-1]=1;
       System.out.println("vehicle parked at position "+posx+"\n");
       
        }
        else 
            System.out.println(pos+ " position not avaliable \n");
    }
    void re(int x[], int pos)
    {
        this.a=x;
        this.posx=pos;
        if(a[posx-1]==1)
        {
       a[posx-1]=0;
       System.out.println("vehicle found at position "+posx+"\n");
       
       System.out.println("vehicle removed \n");
       
        }
        else 
            System.out.println( "no vehicle persent \n");
    }
    
    
    
}
 class parkin implements Runnable
{
    parking p;
 int d[]=new int[10];
 Thread t;
 int position;
 
 parkin(int c[], int p)
 {
     this.d=c;
     this.position=p;
     t=new Thread(this);
     t.start();
 }
 
    @Override
 public void run()
         
 {
     p.add(d,position);
 }
}
 class remove implements Runnable
{
    parking p;
 int d[]=new int[10];
 Thread t;
 int position;
 
 remove(int c[], int p)
 {
     this.d=c;
     this.position=p;
     t=new Thread(this);
     t.start();
 }
 
    @Override
 public void run()
         
 {
     p.re(d,position);
 }
}



class demo 
{

    public static void main(String args[]) 
    {
        int c[] = new int[10];
        for(int i=0;i<10;i++)
            c[i]=0;
        
        parkin p1=new parkin(c,3);
        parkin p2=new parkin(c,5);
        parkin p3=new parkin(c,4);
        remove p4=new remove(c,3);
        remove p5=new remove(c,3);
        remove p6=new remove(c,5);
        
        
    }
}
