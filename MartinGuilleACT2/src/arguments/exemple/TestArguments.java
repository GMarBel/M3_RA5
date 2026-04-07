package arguments.exemple;

public class TestArguments {
	public static void main(String[] args) {
		if(args.length > 0)System.out.println("arg0: " + args[0]);
		else System.out.println("Sin argumentos");
		
		if(args.length > 1)System.out.println("args1: " + args[1]);
	}
}
