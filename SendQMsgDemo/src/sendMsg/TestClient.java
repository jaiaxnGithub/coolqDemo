package sendMsg;

import org.java_websocket.client.WebSocketClient;

public class TestClient{
	public static void main(String[] args) throws Exception {
			WebSocketClient lemocWebSocketClient = LemocWebSocketClientFactory.getLemocWebSocketClient();
			lemocWebSocketClient.connect();
	}
}
