package texasPoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SocketConnection {
	private static Socket player = null;// ��̬��ÿ������ά��ͬһ������
	private static StringBuilder mStringBuilder;
	private static String MsgType[];
	private static PrintWriter printWriter = null;
	private static InputStreamReader streamReader = null;// InputStreamReader�ǵͲ�͸߲㴮��֮�������
	private static BufferedReader reader = null; // player.getInputStream()��Socketȡ�����봮��

		// ��������˷������󣬷�����IP��ַ�ͷ����������Ķ˿ں�


	public SocketConnection() {
		try {
			player = new Socket(IpInfo.ServerIp, IpInfo.ServerPort);
			// ͨ��printWriter ���������������Ϣ
			printWriter = new PrintWriter(player.getOutputStream());
			printWriter.println(Message.REG_MSG + " " + 2333 + " playerName" + " \n");
			printWriter.flush();
			System.out.println("�����ѽ���...");
			streamReader = new InputStreamReader(player.getInputStream());
			// �������ݴ���������BufferedReader����ȡ����BufferReader���ӵ�InputStreamReder
			reader = new BufferedReader(streamReader);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static String SendMsg(String msg) { // ������Ϣ
		printWriter.println(msg);
		printWriter.flush();
		return msg;
	}

	public static String[] ReadMsg() {
		int i = 0;
		String servermsg = null;
		try {
			while ((servermsg = reader.readLine()) != null) {
				mStringBuilder.append(servermsg); // �����Ϣ
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ��Ϣ
		MsgType = mStringBuilder.toString().split(" ");
		return MsgType;
	}

	public static void CloseConnection() {
		try {
			player.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] getMsgList() {
		return MsgType;
	}

	public static Socket getSocket() {
		return player;

	}

	public static PrintWriter getPrintWriter() {
		return printWriter;
	}
}
