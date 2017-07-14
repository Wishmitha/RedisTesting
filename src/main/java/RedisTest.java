/**
 * Created by wishmitha on 7/14/17.
 */
import redis.clients.jedis.*;

import java.util.Iterator;
import java.util.List;

public class RedisTest {

    public static JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");


    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis("localhost");

        jedis.set("a.1","a1");
        jedis.set("a.2","a2");
        jedis.set("a.3","a3");

        jedis.set("b.1","b1");
        jedis.set("b.2","b2");
        jedis.set("b.3","b3");

        jedis.set("c.1","c1");
        jedis.set("c.2","c2");
        jedis.set("c.3","c3");

        jedis.lpush("keys", "a.1","a.2","a.3");

        ScanParams params = new ScanParams();
        params.match("b*");

        List<String> res = jedis.scan("0",params).getResult();

        for (String result:res) {
            System.out.println(result);
        }

        /*System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());


        long initTime = System.currentTimeMillis();
        int initConsumeID = Integer.parseInt(jedis.get("cid"));
        int initMessageID = Integer.parseInt(jedis.get("mid"));

        for (int i=1;i<=1000;i++){
            (new Thread(new Producer("Producer"+Integer.toString(i)))).start();
            (new Thread(new Consumer("Consumer"+Integer.toString(i)))).start();
        }

        System.out.println(System.currentTimeMillis()-initTime);
        System.out.println(Consumer.consumedID-initConsumeID);
        System.out.println(Producer.messageID-initMessageID);

        pool.destroy();*/
    }


}
