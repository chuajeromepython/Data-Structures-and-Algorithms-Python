import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.*;


public class ExpressionParser {
	public static int thisContains(HashMap<String, Integer> map, String key){
		int value;
		if (map.containsKey(key)){
			value = map.get(key);
		} else {
			value = 0;
		}
		return value;
	}
	public static boolean isNumeric(String s){
		try{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException alpha){
			try{
				Double.parseDouble(s);
				return true;
			} catch (NumberFormatException beta){
				return false;
			}
		}
	}
	public static String ShuntingYardAlgorithm(String expr){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringBuilder output = new StringBuilder();
		ArrayList<String> stack = new ArrayList<String>();
		List<String> tokens = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+|\\+|\\-|\\*|/|\\(|\\)|\\^");
		Matcher matcher = pattern.matcher(expr);
		while (matcher.find()){
			tokens.add(matcher.group());
		}
		map.put("+",1);
		map.put("-",1);
		map.put("*",2);
		map.put("/",2);
		map.put("^",3);
		for (String c: tokens){
			if (isNumeric(c)){
				output.append(c).append(" ");
			} else if (c.equals("(")){
				stack.add(c);
			} else if (c.equals(")")){
				while (!stack.isEmpty() && !String.valueOf(stack.get(stack.size()-1)).equals("(")){
					output.append(String.valueOf(stack.remove(stack.size()-1))).append(" ");
				}
				stack.remove(stack.size()-1);
			} else {
				while (!stack.isEmpty() && thisContains(map,String.valueOf(stack.get(stack.size()-1))) >= thisContains(map,c)){
					output.append(String.valueOf(stack.remove(stack.size()-1))).append(" ");
				}
				stack.add(c);
			}
		}
		while (!stack.isEmpty()){
			output.append(String.valueOf(stack.remove(stack.size()-1))).append(" ");
		}
		return output.toString().trim();
	}
	public static int parse_rpn_int(String expr){
		ArrayList<Integer> stack = new ArrayList<Integer>();
		String[] operators = {"+","-","*","/","^"};
		String[] postfix = ShuntingYardAlgorithm(expr).split(" ");
		for (String c: postfix){
			if (!in(c,operators)){
				stack.add(Integer.parseInt(c));
			} else {
				int op2 = stack.remove(stack.size()-1);
				int op1 = stack.remove(stack.size()-1);
				if (c.equals("+")){
					stack.add(op1 + op2);
				} else if (c.equals("-")){
					stack.add(op1 - op2);
				} else if (c.equals("*")){
					stack.add(op1 * op2);
				} else if (c.equals("/")){
					stack.add(op1 / op2);
				} else {
					stack.add((int)Math.pow(op1, op2));
				}
			}	
		}
		return stack.get(0);
	}
	public static double parse_rpn_double(String expr){
		ArrayList<Double> stack = new ArrayList<Double>();
		String[] operators = {"+","-","*","/","^"};
		String[] postfix = ShuntingYardAlgorithm(expr).split(" ");
		for (String c: postfix){
			if (!in(c,operators)){
				stack.add(Double.parseDouble(c));
			} else {
				double op2 = stack.remove(stack.size()-1);
				double op1 = stack.remove(stack.size()-1);
				if (c.equals("+")){
					stack.add(op1 + op2);
				} else if (c.equals("-")){
					stack.add(op1 - op2);
				} else if (c.equals("*")){
					stack.add(op1 * op2);
				} else if (c.equals("/")){
					stack.add(op1 / op2);
				} else {
					stack.add(Math.pow(op1, op2));
				}
			}	
		}
		return stack.get(0);
	}
	public static boolean in(String current, String[] array){
		for (String str: array){
			if (current.equals(str)){
				return true;
			}
		}
		return false;
	}
	public static boolean determineDouble(List<String> postfix){
		boolean isDouble = false;
		for (String str: postfix){
			if (str.contains(".")){
				try{
					Double.parseDouble(str);
					isDouble = true;
				} catch (NumberFormatException nfe){}
			}
		}
		return isDouble;
	}
	public static Object evaluateExpression(String expr){
		List<String> tokens = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+|\\+|\\-|\\*|/|\\(|\\)|\\^");
		Matcher matcher = pattern.matcher(expr);
		while (matcher.find()){
			tokens.add(matcher.group());
		}
		if (determineDouble(tokens)){
			return parse_rpn_double(expr);
		} else {
			return parse_rpn_int(expr);
		}
	}
	public static void main(String[] args) {
		// for expressions with doubles
		System.out.println(evaluateExpression("9.0+24/(7^3)"));
		// for expressions with integers
		System.out.println(evaluateExpression("9 + 24 / (7 - 3)"));	
	}
}
