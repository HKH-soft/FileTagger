package filetagger.ui;

import java.util.Scanner;

import filetagger.logic.logic;

public class UserInterfaceCLIImplementation implements UserInterface {

    logic logic = new logic("/workspaces/FileTagger/filetagger/src/main/java/filetagger/Storage/");
    Scanner scanner = new Scanner(System.in);
    String helpDoc = """
                        getTags -> get a list of all of the avalible tags
                        getLocation -> get the current location
                        getNames -> get a list of the file names on the current location
                        help -> get a list of all of the availebe commands
                        exit -> close the application
                    """;

    @Override
    public void start() {
        while (true) { 
            try{
                String command = scanner.nextLine();
                String[] commands = command.split(" ");
                switch(commands[0]){
                    case "exit" -> {return;}
                    case "help" -> {System.out.println(helpDoc);}
                    case "getNames" -> {
                        for(String name : logic.getNames()){
                            System.out.println(name);
                        }
                    }
                    case "getTags" -> {System.out.println(logic.getTags());}
                    case "getLocation" -> {System.out.println(logic.getLocation());}
                    default -> {System.out.println( "command not found.\n\n" + helpDoc);}
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

}
