package com.baowu.perf4j;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

public class Perf4JAppenderExample {
    public static void main (String[] args) throws Exception {
    	runPerf4j();
    }
    
    public static void runPerf4j() throws Exception{
    	Logger rootLogger = Logger.getRootLogger();
        for (int i = 0; i < 10; i++) {
            // Log4JStopWatch默认使用org.perf4j.TimingLogger这个类
            StopWatch stopWatch = new Log4JStopWatch();
            //模拟代码运行时间
            Thread.sleep((long) (Math.random() * 1000L));
            //打印到控制台
            rootLogger.info("Normal logging messages only go to the console");
            stopWatch.lap("firstBlock");
            Thread.sleep((long) (Math.random() * 2000L));
            stopWatch.stop("secondBlock");
        }
    }
}
