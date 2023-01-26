package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ArchiveParsingTest {
    ClassLoader loader = ArchiveParsingTest.class.getClassLoader();

    @Test
    void zipFileContentParseTest() throws Exception {
        try (
            ZipFile zf = new ZipFile(new File("src/test/resources/archive.zip"));
            ZipInputStream zis = new ZipInputStream(Objects.requireNonNull(loader.getResourceAsStream("archive.zip")));
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                try (InputStream inputStream = zf.getInputStream(entry)) {
                    if (fileName.contains(".pdf")) {
                        PDF content = new PDF(inputStream);
                        if (fileName.contains("TTX")) {
                            assertThat(content.title).isEqualTo("Билет");
                            assertThat(content.numberOfPages).isEqualTo(1);
                            assertThat(content.text).contains("Main Event + Afterparty [happy\n" +
                                "early birds] - 10-11 July");
                        } else {
                            assertThat(content.title).isEqualTo("Болельщикам Северной столицы");
                            assertThat(content.numberOfPages).isEqualTo(1);
                            assertThat(content.text).contains("В случае непредвиденных ситуаций свяжитесь с л" +
                                "идером зоны поддержки вашего клуба.\nЕсли ваш клуб хочет присоединиться к зоне под" +
                                "держки, пишите в телеграм @ShelgornStas");
                        }
                    } else if (fileName.contains(".csv")) {
                        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
                        List<String[]> content = reader.readAll();
                        if (fileName.contains("import")) {
                            assertThat(content.size()).isEqualTo(4);
                            assertThat(content.get(0)[0]).contains("ame");
                            assertThat(content.get(3)[6]).isEqualTo("TWTR");
                        } else {
                            assertThat(content.size()).isEqualTo(30);
                            assertThat(content.get(0)[0]).contains("1540565100");
                            assertThat(content.get(29)[15]).isEqualTo("1844");
                        }
                    } else if (fileName.contains(".xls")) {
                        // parse xls
                        XLS content = new XLS(inputStream);
                        if (fileName.contains("paring")) {
                            assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1)
                                .getStringCellValue()).isEqualTo("Edelzwicker");
                            assertThat(content.excel.getSheetAt(0).getRow(8).getCell(6)
                                .getStringCellValue()).contains("Traminer", "Gumpoldskirchner");
                        } else {
                            assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1)
                                .getStringCellValue()).isEqualTo("What C datatypes are 8 bits? (assume i386)");
                            assertThat(content.excel.getSheetAt(2).getRow(21).getCell(0)
                                .getStringCellValue()).contains("This is an example and template for preparing Blackboard tests offline");
                        }
                    }
                }
            }
        }
    }

}
