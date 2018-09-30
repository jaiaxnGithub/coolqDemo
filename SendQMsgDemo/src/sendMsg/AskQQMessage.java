package sendMsg;

public class AskQQMessage {
    private String act;
    private String QQID;
    private String msg;
    private String groupid;
    private String discussid;
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getQQID() {
		return QQID;
	}
	public void setQQID(String qQID) {
		QQID = qQID;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getDiscussid() {
		return discussid;
	}
	public void setDiscussid(String discussid) {
		this.discussid = discussid;
	}
	@Override
	public String toString() {
		return "AskQQMessage [act=" + act + ", QQID=" + QQID + ", msg=" + msg + ", groupid=" + groupid + ", discussid="
				+ discussid + "]";
	}
}

