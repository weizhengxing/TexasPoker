package texasPoker;

public class Client { // �������

	public static void main(String[] args) {
		IpInfo.ServerIp = args[0];
		IpInfo.ServerPort = Integer.valueOf(args[1]).intValue();
		IpInfo.ClientIp = args[2];
		IpInfo.ClientPort = Integer.valueOf(args[3]).intValue();
		IpInfo.PlayerId = Integer.valueOf(args[4]).intValue();
		Player Meilier = new Player();
		// ��Ϸû�н���
		while (!SocketConnection.getSocket().isConnected()) {

		}
		while(SocketConnection.getPrintWriter()!=null){
			Meilier.RegMsg();
		}
		while (!(SocketConnection.getSocket().isClosed())) {
			Meilier.AnalysisMsg();
		}
	}
}
