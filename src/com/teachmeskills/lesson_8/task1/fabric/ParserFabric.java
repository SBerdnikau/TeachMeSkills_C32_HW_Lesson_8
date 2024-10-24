package com.teachmeskills.lesson_8.task1.fabric;

import com.teachmeskills.lesson_8.task1.document_parser.IParser;
import com.teachmeskills.lesson_8.task1.document_parser.impl.DocXDocumentParser;
import com.teachmeskills.lesson_8.task1.document_parser.impl.PdfDocumentParser;
import com.teachmeskills.lesson_8.task1.document_parser.impl.TxtDocumentParser;

public class ParserFabric {

    public static IParser createParser(String fileName){
//        if(fileName.endsWith(".docx")){
//            // TODO избавиться от return null и сделать возврат docx парсера
//            return new DocXDocumentParser();
//        } else if (fileName.endsWith(".pdf")) {
//            return new PdfDocumentParser();
//        } else {
//            return new TxtDocumentParser();
//        }

        // TODO (опционально) * попробовать переписать на конструкцию switch-case, может это будет более ёмкая запись
        String fileNameExt = fileName.substring(fileName.lastIndexOf('\\') + 1);
        int dotIndex = fileNameExt.lastIndexOf('.');
        String extension = (dotIndex > 0) ? fileNameExt.substring(dotIndex + 1) : "";

         switch (extension){
            case "docx" -> {return new DocXDocumentParser();}
            case "pdf"  -> {return new PdfDocumentParser();}
            default -> {return new TxtDocumentParser();}
        }

    }

}
