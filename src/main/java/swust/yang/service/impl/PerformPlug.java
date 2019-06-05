package swust.yang.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import swust.yang.entity.ExecMessage;
import swust.yang.entity.PluginInfo;
import swust.yang.entity.ResultMsg;
import swust.yang.entity.Stdout;
import swust.yang.service.IPlug;
import swust.yang.util.ExecUtil;
import swust.yang.util.GCCTools;
import swust.yang.util.SystemProperty;

public class PerformPlug implements IPlug {

	@Override
	public ResultMsg singleExecute(String compiler, String toolPath, String sourcePath, String testCaseDir) {
		String tempFileDir = testCaseDir;
		if (!compiler.equals("gcc") && !compiler.equals("g++")) {
			System.err.println("作业执行出错,传入的编译器不是gcc/g++(" + compiler + ")");
			return null;
		}

		File toolFile = new File(toolPath);
		if (!toolFile.exists() || !toolFile.isDirectory()) {
			System.err.println("作业执行出错,传入的工具路径不存在/该路径不是一个目录(" + toolPath + ")");
			return null;
		}

		File srcFile = new File(sourcePath);
		if (!srcFile.exists()) {
			System.err.println("作业执行出错,传入的源文件不存在(" + sourcePath + ")");
			return null;
		}

		File testDir = new File(testCaseDir);
		if (!testDir.exists() || !testDir.isDirectory()) {
			System.err.println("作业执行出错,传入的测试用例所在路径不存在/该路径不是一个目录(" + testCaseDir + ")");
			return null;
		}

		// 用于储存检查结果
		ResultMsg result = new ResultMsg();
		// 当前系统环境下的文件分隔符
		String fileSeparator = SystemProperty.getFileSeparator();
		// 被检查的作业信息
		String studentInfo = sourcePath.substring(sourcePath.lastIndexOf(fileSeparator) + 1,
				sourcePath.lastIndexOf('.'));
		// 对源文件进行编译
		String ret = GCCTools.compile(compiler, sourcePath, tempFileDir);
		if (ret != null) {
			result.setStudentInfo(studentInfo);
			result.setValue("Compile Error");
			result.setMessage("0;0");
			result.setCode(0);
			ExecUtil.exec("rm -rf " + tempFileDir + "/main");
			return result;
		}

		// chmod -R 755 tempFileDir
		ExecUtil.exec("chmod -R 755 " + tempFileDir);
		// 调用lorun模块运行编译后的可执行文件
		String command = "python " + toolPath + fileSeparator + "judge.py" + " " + tempFileDir + "/./main "
				+ testCaseDir + " " + tempFileDir + " " + "1000 65535";
		ExecMessage exec = ExecUtil.exec(command);
		// 分析运行结果
		if (exec.getError() != null) {
			result.setStudentInfo(studentInfo);
			result.setValue("Runtime Error");
			result.setMessage("0;0");
			result.setCode(0);
			ExecUtil.exec("rm -rf " + tempFileDir + "/main");
			return result;
		}
		Stdout out = JSonToObject(exec.getStdout());
		result.setStudentInfo(studentInfo);
		result.setValue(analysis(out.getStatus()));
		result.setMessage(String.valueOf(out.getMax_time()) + ";" + String.valueOf(out.getMax_memory()));
		result.setCode(0);
		ExecUtil.exec("rm -rf " + tempFileDir + "/main");
		return result;
	}

	@Override
	public List<ResultMsg> batchExecute(String configInfo, String toolPath, String srcDir, String logDir) {
		List<ResultMsg> msgs = new ArrayList<ResultMsg>();
		ResultMsg msg = new ResultMsg();
		msg.setMessage("未提供批量执行功能");
		msg.setCode(-1);
		msgs.add(msg);
		return msgs;
	}

	@Override
	public String checkConfigInfo(String configInfo) {
		return "该插件不提供配置信息检查功能";
	}

	@Override
	public PluginInfo getPluginInfo() {
		PluginInfo perform = new PluginInfo();
		perform.setAuthor("yangyechi");
		perform.setDescription("Verify the correctness of the submitted C/C++ code");
		perform.setName("perform-1.0.1.jar");
		perform.setVersion("1.0.1");
		perform.setClassName("swust.yang.service.impl.PerformPlug");
		return perform;
	}

	@Override
	public String getHtml(String preSetting) {
		return "该插件不提供配置界面";
	}

	private Stdout JSonToObject(String data) {
		Stdout dataObj = new Stdout();
		String[] arr = data.split(",");
		String status = arr[0].substring(arr[0].lastIndexOf(' ') + 1).replace('L', ' ');
		String max_memory = arr[1].substring(arr[1].lastIndexOf(' ') + 1).replace('L', ' ');
		String max_time = arr[2].substring(arr[2].lastIndexOf(' ') + 1, arr[2].length() - 1).replace('L', ' ');
		dataObj.setStatus(Integer.valueOf(status.trim()));
		dataObj.setMax_memory(Long.valueOf(max_memory.trim()));
		dataObj.setMax_time(Long.valueOf(max_time.trim()));
		return dataObj;
	}

	private String analysis(Integer status) {
		String ret = null;
		switch (status) {
		case 0:
			ret = "Accepted";
			break;
		case 1:
			ret = "Presentation Error";
			break;
		case 2:
			ret = "Time Limit Exceeded";
			break;
		case 3:
			ret = "Memory Limit Exceeded";
			break;
		case 4:
			ret = "Wrong Answer";
			break;
		case 5:
			ret = "Runtime Error";
			break;
		case 6:
			ret = "Output Limit Exceeded";
			break;
		case 7:
			ret = "Compile Error";
			break;
		case 8:
			ret = "System Error";
			break;
		}
		return ret;
	}

}