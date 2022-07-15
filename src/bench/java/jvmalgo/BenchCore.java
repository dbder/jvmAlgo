package jvmalgo;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;

public abstract class BenchCore {

    @Test
    public void runJmho() throws RunnerException {
//        System.out.println(this.getClass().getName());
        if (this.getClass().getName().contains("_jmhType_")) return;
        var dir = this.getClass().getName().replace(".", "/");
        dir = "src/bench/resources/" + dir.substring(0, dir.lastIndexOf("/") + 1);

        new File(dir).mkdirs();
        Options opt = new OptionsBuilder()
                .include(this.getClass().getName())
                .warmupIterations(1)
                .measurementIterations(1)
//                .addProfiler(GCProfiler.class)
//                .addProfiler(JavaFlightRecorderProfiler.class)
                .resultFormat(ResultFormatType.JSON)
                .result(dir + this.getClass().getSimpleName() + ".json")
                .build();
        new Runner(opt).run();
    }

}
