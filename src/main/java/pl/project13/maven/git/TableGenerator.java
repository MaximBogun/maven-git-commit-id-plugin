package pl.project13.maven.git;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Properties;

class TableGenerator {

    private static final String TEMPLATE_START = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <style>\n" +
            "#table-body {\n" +
            "    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
            "    border-collapse: collapse;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            "#table-body td, #table-body th {\n" +
            "    border: 1px solid #ddd;\n" +
            "    padding: 8px;\n" +
            "}\n" +
            "\n" +
            "#table-body tr:nth-child(even){background-color: #f2f2f2;}\n" +
            "\n" +
            "#table-body tr:hover {background-color: #ddd;}\n" +
            "\n" +
            "#table-body th {\n" +
            "    padding-top: 12px;\n" +
            "    padding-bottom: 12px;\n" +
            "    text-align: left;\n" +
            "}"
            + "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<table id = \"table-body\">\n" +
            "    <tr>\n" +
            "        <th>Column</th>\n" +
            "        <th>Value</th>\n" +
            "    </tr>";
    private static final String TEMPLATE_PROPERTY =
            "   <tr>\n" +
            "        <td>{KEY}</td>\n" +
            "        <td>{VALUE}</td>\n" +
            "    </tr>\n";
    private static final String TEMPLATE_END =
                    "</table>\n" +
                    "</body>\n" +
                    "</html>\n";

    static String propertiesToHtmlTable(@NotNull Properties properties) {
        StringBuilder stringBuilder = new StringBuilder(TEMPLATE_START);
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            stringBuilder.append((TEMPLATE_PROPERTY.replaceAll("{KEY}", String.valueOf(entry.getKey()))).replaceAll("{VALUE}", String.valueOf(entry.getValue())));
        }
        return stringBuilder.append(TEMPLATE_END).toString();
    }
}
