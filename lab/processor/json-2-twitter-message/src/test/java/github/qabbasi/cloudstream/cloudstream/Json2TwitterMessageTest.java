package github.qabbasi.cloudstream.cloudstream;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@IntegrationTest
@SuppressWarnings("unchecked")
public class Json2TwitterMessageTest {

    @Autowired
    Processor json2Twitter;

    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void transformTwitterMessage() throws Exception {
        Message<String> inputMessage = new GenericMessage<>($("twitterMessage.json"));

        json2Twitter.input().send(inputMessage);

        Message<String> result = (Message<String>) messageCollector.forChannel(json2Twitter.output()).poll();

        Assert.assertThat(result.getPayload(), is($("expectedTwitterMessage.json")));
    }

    private String $(String fileName) throws IOException {
        URL url = Resources.getResource(fileName);
        return Resources.toString(url, Charsets.UTF_8);
    }
}