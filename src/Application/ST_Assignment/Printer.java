package ST_Assignment;

public class Printer {
	
	public void printInfo(String name, String member_type, String room_type) {
		System.out.println("\n==============================================");
        System.out.println("                   Result                     ");
        System.out.println("==============================================\n");
        System.out.println("        Name          : " + name);
        System.out.println("        Member Type   : " + member_type);
        System.out.println("        Room Type     : " + room_type);
        System.out.println("\n==============================================");

	}
}

//public static void printInfo(String name, String member_type, String room_type) {
//StringBuilder sb = new StringBuilder();
//sb.append("\n==============================================\n");
//sb.append("                   Result                     \n");
//sb.append("==============================================\n");
//sb.append("        Name          : ").append(name).append("\n");
//sb.append("        Member Type   : ").append(member_type).append("\n");
//sb.append("        Room Type     : ").append(room_type).append("\n");
//sb.append("\n==============================================\n");
//System.out.println(sb.toString());
//}
