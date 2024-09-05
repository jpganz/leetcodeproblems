package leetcode.java.general;


/*
https://leetcode.com/problems/climbing-stair
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LoggerRateLimiter {

    class Logger {

        private HashMap<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if ((map.getOrDefault(message,0) <= timestamp)) {
                map.put(message, timestamp + 10);
                return true;
            } else {
                return false;
            }
        }
    }



    public static void main(String[] args) {
        LoggerRateLimiter limiter = new LoggerRateLimiter();
        Logger logger = limiter.new Logger();
        logger.shouldPrintMessage(1, "foo");
        logger.shouldPrintMessage(2, "bar");
        logger.shouldPrintMessage(3, "bar");
        logger.shouldPrintMessage(8, "foo");
        logger.shouldPrintMessage(11, "foo");
    }


}
