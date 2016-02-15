package cc.openhome;

/**
 * Created by zhujie on 16/2/15.
 */
public class MessageService {
    private Message[] fakeMessages;

    public MessageService() {
        fakeMessages = new Message[3];
        fakeMessages[0] = new Message("caterpillar", "caterpillar's message!");
        fakeMessages[1] = new Message("momor", "momor's message!");
        fakeMessages[2] = new Message("hamimi", "hamimi's message!");
    }

    public Message[] getMessages() {
        return fakeMessages;
    }
}
