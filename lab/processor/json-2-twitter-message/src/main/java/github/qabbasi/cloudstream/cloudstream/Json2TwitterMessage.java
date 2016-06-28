package github.qabbasi.cloudstream.cloudstream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;

@EnableBinding(Processor.class)
public class Json2TwitterMessage {

    @Autowired
    ObjectMapper mapper;

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String transform(String rawDatum) throws IOException {
        TwitterMessage message = mapper.readValue(rawDatum, TwitterMessage.class);
        return mapper.writeValueAsString(message);
    }

}