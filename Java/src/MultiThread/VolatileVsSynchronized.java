package MultiThread;

/**
 * Created by yunlong on 2/28/16.
 */
public class VolatileVsSynchronized extends Thread{
//    public   static volatile int  n  =   0 ;
//    public   void  run()
//    {
//        for  ( int  i  =   0 ; i  <   10 ; i ++ )
//            try
//            {
//                n  =  n  +   1 ;
//                sleep(3);  //  为了使运行结果更随机，延迟3毫秒
//            }
//            catch  (Exception e)
//            {
//            }
//    }
//
//    public   static   void  main(String[] args)  throws  Exception
//    {
//        Thread threads[]  =   new  Thread[ 100 ];
//        for  ( int  i  =   0 ; i  <  threads.length; i ++ )
//            //  建立100个线程
//            threads[i]  =  new  VolatileVsSynchronized();
//        for  ( int  i  =   0 ; i  <  threads.length; i ++ )
//            //  运行刚才建立的100个线程
//            threads[i].start();
//        for  ( int  i  =   0 ; i  <  threads.length; i ++ )
//            //  100个线程都执行完后继续
//            threads[i].join();
//        System.out.println( " n = "   +  VolatileVsSynchronized.n);
//    }
    public   static int  n  =   0 ;
    public static   synchronized   void  inc()
    {
        n ++ ;
    }
    public   void  run()
    {
        for  ( int  i  =   0 ; i  <   10 ; i ++ )
            try
            {
                inc();  //  n = n + 1 改成了 inc();
                sleep( 3 );  //  为了使运行结果更随机，延迟3毫秒

            }
            catch  (Exception e)
            {
            }
    }

    public   static   void  main(String[] args)  throws  Exception
    {

        Thread threads[]  =   new  Thread[ 100 ];
        for  ( int  i  =   0 ; i  <  threads.length; i ++ )
            //  建立100个线程
            threads[i]  =   new  VolatileVsSynchronized();
        for  ( int  i  =   0 ; i  <  threads.length; i ++ )
            //  运行刚才建立的100个线程
            threads[i].start();
        for  ( int  i  =   0 ; i  <  threads.length; i ++ )
            //  100个线程都执行完后继续
            threads[i].join();
        System.out.println( " n= "   +  VolatileVsSynchronized.n);
    }
}
