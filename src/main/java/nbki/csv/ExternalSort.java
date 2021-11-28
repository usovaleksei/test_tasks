package nbki.csv;

import com.google.code.externalsorting.csv.CsvExternalSort;
import com.google.code.externalsorting.csv.CsvSortOptions;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * class for sorting big csv file
 * used externalsortinginjava 0.6.0 API
 *
 * @author Aleksei Usov
 * @since 28/11/2021
 */
public class ExternalSort {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Comparator<CSVRecord> comparator = (op1, op2) -> {
            String fid1 = op1.get(0).split(";")[0];
            String fid2 = op2.get(0).split(";")[0];
            return fid1.compareTo(fid2);
        };
        CsvSortOptions sortOptions = new CsvSortOptions
                .Builder(comparator, CsvExternalSort.DEFAULTMAXTEMPFILES, CsvExternalSort.estimateAvailableMemory())
                .charset(Charset.defaultCharset())
                .distinct(false)
                .numHeader(1)
                .skipHeader(false)
                .format(CSVFormat.DEFAULT)
                .build();

        List<File> sortInBatch = CsvExternalSort.sortInBatch(new File("dump.txt"), null, sortOptions, new ArrayList<>());

        CsvExternalSort.mergeSortedFiles(sortInBatch, new File("newFile"), sortOptions, true, new ArrayList<>());
    }
}
