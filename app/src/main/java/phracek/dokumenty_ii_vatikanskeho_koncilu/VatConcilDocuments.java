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
        String res_name = "";
        int i=0;
        for (i=0; i<text.length;i++) {
            if (i==0)
                res_name += Character.toUpperCase(text[i].charAt(0)) + text[i].substring(1);
            else
                res_name += " " + Character.toUpperCase(text[i].charAt(0)) + text[i].substring(1);

        }
        return res_name;
    }}
