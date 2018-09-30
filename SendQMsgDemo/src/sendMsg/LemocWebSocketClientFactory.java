package sendMsg;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;

public class LemocWebSocketClientFactory {
    private static WebSocketClient webSocketClient = null;
    public static WebSocketClient getLemocWebSocketClient() throws Exception{
                    if(webSocketClient==null){
                                    webSocketClient = new LemocWebSocketClient(new URI("ws://127.0.0.1:25303"), new Draft_17());
                    }
                    return webSocketClient;
            }
}
