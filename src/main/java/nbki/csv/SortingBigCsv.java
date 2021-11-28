package nbki.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * class for sorting big csv file
 *
 * @author Aleksei Usov
 * @since 28/11/2021
 */
public class SortingBigCsv {

    /**
     * method for split original file to more small file
     * with limit by number of lines
     *
     * @param in - InputStream from original file
     * @throws IOException - IOException
     */
    public void split(InputStream in) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            int curSize = 0;
            while ((line = br.readLine()) != null) {
                list.add(line);
                curSize += 1;
                if (curSize > 3) {
                    List<Model> sortedModels = convertToSortedModel(list);
                    File file = new File("temp" + System.currentTimeMillis());
                    writeOut(sortedModels, new FileOutputStream(file));
                    curSize = 0;
                }
            }
        }
    }

    /**
     * method write sorted POJO of lines to file
     *
     * @param models - list of sorted models
     * @param os     - outputStream
     * @throws IOException - IOException
     */
    private void writeOut(List<Model> models, OutputStream os) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            for (Model model : models) {
                String line = Model.toCsvLine(model);
                bw.write(line);
            }
            bw.flush();
        }
    }

    /**
     * method convert every line list of POJO's
     *
     * @param lines - lines from origin file
     * @return - list of POJO's
     */
    private List<Model> convertToSortedModel(List<String> lines) {
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
}
