package ua.edu.ucu.apps.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MockedDocument implements Document {

    public String gcsPath;

    @Override
    public String parse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Mocked parse Result";
    }

    @Override
    public String getGcsPath() {
        throw new UnsupportedOperationException("Unimplemented method 'getGcsPath'");
    }
    
}
