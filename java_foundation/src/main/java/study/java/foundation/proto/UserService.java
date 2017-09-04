package study.java.foundation.proto;

import study.java.foundation.proto.RequestMsgProtoBuf.RequestMsg;
import study.java.foundation.proto.UserProtoBuf.User;

public class UserService {
	public static void main(String[] args) {
		UserService userService = new UserService();
		User user = userService.saveUser();
		System.out.println(user.getUserId());
	}

	public User saveUser() {
		User.Builder user = User.newBuilder();
		
		user.setPhoneNumber("138XXXXXXX");
		user.setUserId(18);
		user.setUserName("xiaoming");
		
		RequestMsg.Builder request = RequestMsg.newBuilder();
		request.setCmd("saveUser");
		request.setParam(user.build().toByteString());
		
		return (User)Client.startClient(request);
	}
}
