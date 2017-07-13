package pl.com.britenet.kta.examples;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Recognition {

    public String quote;

    public Recognition(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Recognition{" +
                "quote='" + quote + '\'' +
                '}';
    }
}
