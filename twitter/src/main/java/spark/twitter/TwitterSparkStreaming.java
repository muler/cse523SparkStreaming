package spark.twitter;

import org.apache.spark.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.twitter.*;
import twitter4j.GeoLocation;
import twitter4j.Status;

public class TwitterSparkStreaming {
	public static void main(String[] args) {
		final String consumerKey = "9UZhTzXK8TGrMwvkpUsiX7VyS";
        final String consumerSecret = "9KwwczHtqgS4VV3oJBqQtXWZaVHAdF9NXfMXps2K3bxP9iozi6";
        final String accessToken = "257451099-S9p32C4UtHBVVJh0xMH6yYzfa752i4g9uGutOwbI";
        final String accessTokenSecret = "VF5E5Ii0DfloK3mtzPS0cIHz0RLsvMIdmNjUZCKCRRRo1";

        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("SparkTwitterStreaming");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, new Duration(5000));

        System.setProperty("twitter4j.oauth.consumerKey", consumerKey);
        System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret);
        System.setProperty("twitter4j.oauth.accessToken", accessToken);
        System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret);

        JavaReceiverInputDStream<Status> twitterStream = TwitterUtils.createStream(jssc);

        // Without filter: Output text of all tweets
        JavaDStream<String> statuses = twitterStream.map(
                new Function<Status, String>() {
                    public String call(Status status) {
                    	System.out.println("Tweets are coming: " + status.getText());
                    	return status.getText(); }
                }
        );

       //to anlysis and store it to hive/hbase
     
        statuses.print();jssc.start();
        
    }

}
