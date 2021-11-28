package nbki.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for sorting lines in csv-file by first field
 *
 * @author Aleksei Usov
 * @since 27/11/2021
 */

public class SortingCSV {

    /**
     * method for load data
     *
     * @return - list every line from file
     * @throws IOException - IOException
     */
    public List<String> load() throws IOException {
        try (BufferedReader rd = new BufferedReader(new FileReader("dump.txt"))) {
            return rd.lines()
                    .collect(Collectors.toList());
        }
    }

    /**
     * method for convert every line from file to POJO
     * and to sort lines by first field
     *
     * @param lines - lines getting from file
     * @return - list of models
     */
    private List<Model> convertToModel(List<String> lines) {
        List<Model> models = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            Model model = new Model(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    parts[3],
                    parts[4],
                    parts[5],
                    parts[6],
                    parts[7]
            );
            models.add(model);
        }
        models.sort(Comparator.comparing(Model::getFid));
        return models;
    }

    /**
     * method write sorting lines into new cvs file
     *
     * @param models - sorting list of model
     * @throws IOException - IOException
     */
    private void writeToFile(List<Model> models) throws IOException {
        FileWriter fileWriter = new FileWriter("newCSV");
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Model model : models) {
                String writeString = Model.toCsvLine(model);
                bufferedWriter.write(writeString);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        SortingCSV task = new SortingCSV();
        List<String> lines = task.load();
        List<Model> models = task.convertToModel(lines);
        task.writeToFile(models);
    }
}
