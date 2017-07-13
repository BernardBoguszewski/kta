package pl.com.britenet.kta.examples;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Colleague {

    @Id
    public String id;

    public String name;
    public List<Recognition> recognitions;

    public Colleague() {
        this.recognitions = new ArrayList<>();
    }

    public Colleague(String name) {
        this.name = name;
        this.recognitions = new ArrayList<>();
    }

    public Colleague(String name, List<Recognition> recognitions) {
        this.name = name;
        this.recognitions = recognitions;
    }

    @Override
    public String toString() {
        return "Colleague{" +
                ", name='" + name + '\'' +
                ", recognitions=" + recognitions +
                '}';
    }
}
