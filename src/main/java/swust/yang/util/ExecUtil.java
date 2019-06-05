package swust.yang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import swust.yang.entity.ExecMessage;

public class ExecUtil {

	public static ExecMessage exec(String command) {
		Runtime runtime = Runtime.getRuntime();
		Process exec = null;
		try {
			if (SystemProperty.getOSName().equals("Linux")) {
				String[] cmd = new String[]{"/bin/sh", "-c",command};
				exec = runtime.exec(cmd);
			} else {
				exec = runtime.exec("cmd /c " + command);
			}
			// 关闭流释放资源
			if (exec != null) {
				exec.getOutputStream().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			ExecMessage msg = new ExecMessage();
			msg.setError(e.getMessage());
			return msg;
		}
		ExecMessage res = new ExecMessage();
		res.setError(message(exec.getErrorStream()));
		res.setStdout(message(exec.getInputStream()));
		// 销毁子进程
		exec.destroy();
		exec = null;
		return res;
	}

	private static String message(InputStream inputStream) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			StringBuilder message = new StringBuilder();
			String str;
			while ((str = reader.readLine()) != null) {
				message.append(str);
			}
			String result = message.toString();
			if (result.equals("")) {
				return null;
			}
			return result;
		} catch (IOException e) {
			return e.getMessage();
		} finally {
			try {
				inputStream.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
