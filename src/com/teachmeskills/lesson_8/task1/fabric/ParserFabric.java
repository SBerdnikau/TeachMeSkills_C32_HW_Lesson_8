package com.teachmeskills.lesson_8.task1.fabric;

import com.teachmeskills.lesson_8.task1.document_parser.IParser;
import com.teachmeskills.lesson_8.task1.document_parser.impl.DocXDocumentParser;
import com.teachmeskills.lesson_8.task1.document_parser.impl.PdfDocumentParser;
import com.teachmeskills.lesson_8.task1.document_parser.impl.TxtDocumentParser;

public class ParserFabric {

    public static IParser createParser(String fileName){

        // TODO (опционально) * попробовать переписать на конструкцию switch-case, может это будет более ёмкая запись
         return switch (fileName.split("\\.")[1]){
            case "docx" ->  new DocXDocumentParser();
            case "pdf"  ->  new PdfDocumentParser();
            default ->  new TxtDocumentParser();
        };
    }
}