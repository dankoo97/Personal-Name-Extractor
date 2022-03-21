class Archivist {
    public static void main(String args[]) {
        Archivist archivist = new Archivist();
        if (args.length() > 0)
        {
//            Try to run a command based on user CLI input using switch statement
//            If unable throw Error
        } else {
//            Open up shell environment
            archivist.shell();
        }
    }

    public void shell() {
        boolean cont = true;

        while (cont) {
            System.out.println("Please enter a command. Enter \"help\" for a list of commands");
            Scanner scan = new Scanner(System.in);

            cont = false;
        }
    }

    public static String helpCommands() {
//        Extractions
//        Extract from string
//        Extract from file
//        Extract from directory
//
//        Train program
//        Given corrected output, train to match
        return "";
    }

    public String extract(String s) {
        return s;
    }


    public String extract(File f) {
        return "";
    }
}