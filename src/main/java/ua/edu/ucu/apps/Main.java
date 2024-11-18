package ua.edu.ucu.apps;

import ua.edu.ucu.apps.decorator.MockedDocument;
// import ua.edu.ucu.apps.decorator.SmartDocument;
import ua.edu.ucu.apps.decorator.TimedDocument;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MockedDocument mockedDocument = new MockedDocument();
        System.out.println(mockedDocument.parse());

        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        System.out.println(timedDocument.parse());
    }
}