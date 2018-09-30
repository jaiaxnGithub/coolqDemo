package sendMsg;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import com.google.gson.Gson;

public class LemocWebSocketClient extends WebSocketClient{
    public LemocWebSocketClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
        // TODO Auto-generated constructor stub
	}
	
	public void onClose(int arg0, String arg1, boolean arg2) {
	        // TODO Auto-generated method stub
	        System.out.println("客户端关闭时,会触发一次这里?想做些什么么?");
	}
	
	public void onError(Exception arg0) {
	        // TODO Auto-generated method stub
	        System.out.println("客户端每次报错的时候,都会触发一次这里?想做些什么么?");
	}
	
	public void onMessage(String json) {
	        // TODO Auto-generated method stub
	        System.out.println("最核心的地方了,每次接收到qq信息,都会触发这里一次;并将QQ信息的json字符串封装到参数的json中");
	        //将json字符串利用GSON转化成pojo对象,利用面向对象的方式处理qq信息
	        QQMessage receiveMessage = (QQMessage) new Gson().fromJson(json, QQMessage.class);
	        //获得qq信息来源的qq号以及qq信息的内容
	        String qq = receiveMessage.getFromQQ();
	        String msg = receiveMessage.getMsg();
	        String username = receiveMessage.getUsername();
	        String fromAnonymous = receiveMessage.getFromAnonymous();
	        String fromGroup = receiveMessage.getFromGroup();              
	        String fromGroupName = receiveMessage.getFromGroupName();
	        System.out.println("receiveMessage"+receiveMessage.toString());
	        //封装将要返回的qq信息
	        AskQQMessage askMessage = new AskQQMessage();
	        //私聊
//	        askMessage.setAct("106"); 
//	        askMessage.setQQID(qq); //将要发送消息的对象
//	        askMessage.setMsg("你对"+qq+"竖起了拇指,并戳瞎了他的眼睛,就因为他对你说了一句"+msg); //将要发送消息的内容
	        //把将要返回的qq信息的对象,解析成json字符串
	        //群聊
	        askMessage.setAct("101"); 
//	        askMessage.setQQID(qq); //将要发送消息的对象
	        askMessage.setGroupid(fromGroup);
	        askMessage.setMsg("[CQ:at,qq="+qq+"] 你好呀！");
	        String ask = new Gson().toJson(askMessage);
	        System.out.println(ask);
	        //将处理好的消息发送出去
	        send(ask);
	}
	
	public void onOpen(ServerHandshake arg0) {
	        // TODO Auto-generated method stub
	        System.out.println("客户端启动时,会触发一次这里?想做些什么么?");
	}
	
}

