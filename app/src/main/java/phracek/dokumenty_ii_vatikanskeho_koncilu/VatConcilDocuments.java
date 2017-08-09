package phracek.dokumenty_ii_vatikanskeho_koncilu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phracek on 8/3/17.
 */

public class VatConcilDocuments {
    public String name;
    public String document_name;
    public String language;
    public String concil_document;

    public VatConcilDocuments(String document_name, String language, String concil_document) {
        this.name = this.document_name;
        this.document_name = capitalize(document_name);
        this.language = language;
        this.concil_document = concil_document;
    }
    private String capitalize(final String line) {
        String [] text = line.split("_");
        String first_name = Character.toUpperCase(text[0].charAt(0)) + text[0].substring(1);
        String second_name = Character.toUpperCase(text[1].charAt(0)) + text[1].substring(1);
        return first_name + " " + second_name;
    }}
