package phracek.dokumenty_ii_vatikanskeho_koncilu;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phracek on 8/8/17.
 */

public class DocumentDb {
    List<VatConcilDocuments> documentDb = new ArrayList<VatConcilDocuments>();

    public DocumentDb() {
    }

    public void addToDb (String document_name, String language, String concil_document){
        VatConcilDocuments item = new VatConcilDocuments(document_name, language, concil_document);
        documentDb.add(item);
    }

    public VatConcilDocuments get (int position) {
        return documentDb.get(position);
    }

    public String getDocu(String language, String title) {
        for (int i=0; i< documentDb.size();i++){
            VatConcilDocuments doc = documentDb.get(i);
            if (doc.language.equals(language) && doc.document_name.equals(title)){
                return doc.concil_document;
            }
        }
        return "";
    }

    public int size() {
        return documentDb.size();
    }

}
