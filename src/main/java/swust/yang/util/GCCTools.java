package swust.yang.util;


public class GCCTools {

	/**
	 * 
	 * @param compiler 编译器gcc/g++
	 * @param srcPath  源文件所在路径
	 * @param destDir  编译后的文件所在路径
	 * @return
	 */
	public static String compile(String compiler,String srcPath,String destDir){
		String cmd = compiler + " " + srcPath + " -o " + destDir + "/main -w -lm";
		return ExecUtil.exec(cmd).getError();
	}
}
