package texasPoker;

public class Game {		//程序入口

	public static void main(String[] args) {
		IpInfo.ServerIp = args[0];
		IpInfo.ServerPort = args[1];
		IpInfo.ClientIp = args[2];
		IpInfo.ClientPort = args[3];
		IpInfo.PlayerId = Integer.valueOf(args[4]).intValue();
		Player Meilier=new Player();
		//游戏没有结束
		while(!(SocketConnection.getSocket().isClosed())){
			Meilier.AnalysisMsg();
		}
	}
}
