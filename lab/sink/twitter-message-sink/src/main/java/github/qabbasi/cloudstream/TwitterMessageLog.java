package github.qabbasi.cloudstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import javax.annotation.PostConstruct;

@EnableBinding(Sink.class)
public class TwitterMessageLog {

    private static Logger logger;

    @PostConstruct
    public void init() {
        logger = LoggerFactory.getLogger(TwitterMessageLog.class);
    }

    @StreamListener(Sink.INPUT)
    public void log(String message) {
        logger.info("Twitter Message: {}", message);
    }

}