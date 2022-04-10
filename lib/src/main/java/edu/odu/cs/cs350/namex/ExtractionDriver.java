package edu.odu.cs.cs350.namex;

public class ExtractionDriver {
    public static void main(String[] args) {
        /// TODO: main function things
        Archivist archivist = new Archivist();

        if (args.length > 0) {
            // Some sample functions
            switch (args[0]) {
                case "extract-string":
                    archivist.extract(args[1]);
                    break;
                case "train":
                    archivist.trainArchivist(new String[]{args[1]});
                    break;
            }
        } else {
            // Enter the shell
            archivist.shell();
        }
    }
}
