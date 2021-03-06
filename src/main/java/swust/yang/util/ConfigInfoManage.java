package swust.yang.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import swust.yang.entity.CppcheckConfigInfo;
import swust.yang.entity.CpplintConfigInfo;

public class ConfigInfoManage {

	/**
	 * 
	 * @description 把配置信息(选择的检查项对应的规则)写入filefileter.txt文件
	 * @param config          配置信息
	 * @param fileFilterPath 规则存放路径(包含文件名)
	 */
	public static void ruleConfig(CpplintConfigInfo config, String fileFilterPath) {
		try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fileFilterPath))) {
			// 字符串缓冲区
			StringBuilder strBuilder = new StringBuilder();
			// 获取CpplintConfigInfo类的所有公共方法
			Method[] methods = config.getClass().getMethods();
			// 遍历获取的公共方法数组
			for (Method m : methods) {
				// 寻找方法名开头为getCheck的公共方法
				if (m.getName().startsWith("getCheck")) {
					// 调用该get方法并获取其返回值
					String s = (String) m.invoke(config);
					if (s != null && !s.equals("")) {
						if (m.getName().equals("getCheckExtendRules")) {
							String[] sList = s.split(";");
							for (String item : sList) {
								strBuilder.append(item.trim() + "\n");
							}
						} else {
							strBuilder.append(s + "\n");
						}
					}
				}
			}
			// 把需要检查项对应的规则写入filefilter.txt文件
			char[] buf = strBuilder.toString().toCharArray();
			bufWriter.write(buf, 0, buf.length);
			bufWriter.flush();
		} catch (IOException e) {
			System.err.println("文件写入失败，请检查filefilter路径:" + fileFilterPath);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @description 用于返回一个HashMap实例,存储了配置的规则及对应分数(用于日志解析)
	 * @param config 配置信息(CpplintConfigInfo对象)
	 * @return 一个HashMap实例,里面存储了老师配置的规则(key)及该规则对应分数(value)
	 */
	public static Map<String, Float> getRulesAndScores(CpplintConfigInfo config) {
		String rule = null;
		Float score = null;
		Map<String, Float> map = new HashMap<String, Float>();
		// 获取CpplintConfigInfo类的所有公共方法
		Method[] methods = config.getClass().getMethods();
		// 遍历获取的公共方法数组
		for (Method m : methods) {
			// 寻找方法名开头为getCheck的公共方法
			if (m.getName().startsWith("getCheck")) {
				try {
					// 调用该get方法并获取其返回值
					rule = (String) m.invoke(config);
					if (rule != null && !rule.equals("")) {
						// 若rule存在且不为空,那么获取该Rule由用户设置的分数
						// 得到获取分数的方法对象
						String MethodName = "getScoreOf" + m.getName().substring(8);
						try {
							// 调用该方法并获取设置分数
							score = (Float) config.getClass().getMethod(MethodName).invoke(config);
							// 将规则及对应分数写入map
							// 如果是扩展的规则,对规则进行处理,分数取平均分(扩展规则对应总分/扩展规则数)
							if (m.getName().equals("getCheckExtendRules")) {
								String[] sList = rule.split(";");
								float avg_score = score / sList.length;
								for (String item : sList) {
									map.put(item.trim(), avg_score);
								}
							} else {
								map.put(rule, score);
							}
						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						}
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	public static Map<String, Float> getRulesAndScores(CppcheckConfigInfo config) {
		String rule = null;
		Float score = null;
		Map<String, Float> map = new HashMap<String, Float>();
		// 获取CpplintConfigInfo类的所有公共方法
		Method[] methods = config.getClass().getMethods();
		// 遍历获取的公共方法数组
		for (Method m : methods) {
			// 寻找方法名开头为getCheck的公共方法
			if (m.getName().startsWith("getCheck")) {
				// 调用该get方法并获取其返回值
				try {
					rule = (String) m.invoke(config);
					if (rule != null && !rule.equals("")) {
						String MethodName = "getScoreOf" + m.getName().substring(8);
						try {
							score = (Float) config.getClass().getMethod(MethodName).invoke(config);
							map.put(rule, score);
						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						}
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			else if(m.getName().equals("getScoreOfError")) {
				try {
					score = (Float) config.getClass().getMethod(m.getName()).invoke(config);
					map.put("error",score);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @param config     配置信息
	 * @param methodName 要调用的方法名(CpplintConfigInfo里的getScore开头的方法)
	 * @return 返回获取的分数(默认为null,即表示该项检查没有选中)
	 * 
	 */
	public static String analysisConfigInfo(CpplintConfigInfo config, String methodName) {
		String s = "null";
		if (!methodName.equals("getScoreOfExtendRules") && !methodName.equals("getScoreOfIdentationStyle")) {
			try {
				Float score = (Float) config.getClass().getMethod(methodName).invoke(config);
				if (score != null) {
					s = score.toString();
				} 
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				return null;
			}
		} else if (methodName.equals("getScoreOfExtendRules")) {
			try {
				Float score = (Float) config.getClass().getMethod(methodName).invoke(config);
				if (score != null) {
					String mName = "getCheck" + methodName.substring(10);
					String rule = (String) config.getClass().getMethod(mName).invoke(config);
					s = score.toString() + "+" + rule;
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			try {
				Float score = (Float) config.getClass().getMethod(methodName).invoke(config);
				if (score != null) {
					String mName = "getCheck" + methodName.substring(10);
					String rule = (String) config.getClass().getMethod(mName).invoke(config);
					if (rule.equals("~ RULE_4_1_A_A_use_tab_for_indentation")) {
						s = score.toString() + "+" + "tab";
					} else {
						s = score.toString() + "+" + "space";
					}
				} 
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				return null;
			}
		}
		if(!s.equals("null") && !methodName.equals("getScoreOfExtendRules") && !methodName.equals("getScoreOfIdentationStyle")) {
			return s.substring(0,s.indexOf('.'));
		}
		return s;
	}

	/**
	 * 
	 * @param config     配置信息
	 * @param methodName 要调用的方法名(CppcheckConfigInfo里的getScore开头的方法)
	 * @return 返回获取的分数(默认为null,即表示该项检查没有选中)
	 * 
	 */
	public static String analysisConfigInfo(CppcheckConfigInfo config, String methodName) {
		String s = "null";
		try {
			Float score = (Float) config.getClass().getMethod(methodName).invoke(config);
			if (score != null) {
				s = score.toString();
				return s.substring(0,s.indexOf('.'));
			} 
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
		return s;
	}
	
	/**
	 * 
	 * @param array 待检查的规则数组
	 * @return 返回对传入规则检查的结果描述。如果检查没有问题则返回OK,反之返回错误描述。
	 */
	public static String isRulesExist(String[] array) {
		// 新建一个HashMap对象,用于存储扩展规则及使用次数
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 扩展规则列表
		String[] list = { 
				"~ RULE_3_3_A_start_function_name_with_is_or_has_when_return_bool",
				"~ RULE_4_1_B_indent_each_enum_item_in_enum_block",
				"~ RULE_4_1_B_locate_each_enum_item_in_seperate_line",
				"~ RULE_4_1_C_align_long_function_parameter_list",
				"~ RULE_4_1_E_align_conditions",
				"~ RULE_4_2_A_A_space_around_operator",
				"~ RULE_4_5_A_brace_for_namespace_should_be_located_in_seperate_line",
				"~ RULE_4_5_A_braces_for_function_definition_should_be_located_in_seperate_line",
				"~ RULE_4_5_A_braces_for_type_definition_should_be_located_in_seperate_line",
				"~ RULE_4_5_A_indent_blocks_inside_of_function",
				"~ RULE_4_5_A_matching_braces_inside_of_function_should_be_located_same_column",
				"~ RULE_5_2_C_provide_doxygen_namespace_comment_on_namespace_def",
				"~ RULE_5_2_C_provide_doxygen_struct_comment_on_struct_def",
				"~ RULE_6_2_A_do_not_use_system_dependent_type",
				"~ RULE_6_4_B_initialize_first_item_of_enum", 
				"~ RULE_6_5_B_do_not_use_macro_for_constants",
				"~ RULE_7_1_B_A_do_not_use_double_assignment", 
				"~ RULE_7_1_C_do_not_use_question_keyword",
				"~ RULE_8_1_A_provide_file_info_comment", 
				"~ RULE_10_1_B_do_not_use_bufferoverflow_risky_function_for_windows"
				};
		// HashMap初始化
		for (String item : list) {
			map.put(item, 0);
		}
		// 检查输入的规则是否存在
		for (String item : array) {
			item = item.trim();
			if (!map.containsKey(item)) {
				return "输入的规则(" + item + ")不存在或者输入的规则不符合规范！请检查！";
			} else {
				if (map.get(item) == 0) {
					map.put(item, 1);
				} else {
					return "输入的规则(" + item + ")重复！请检查！";
				}
			}
		}
		return "OK";
	}
}
