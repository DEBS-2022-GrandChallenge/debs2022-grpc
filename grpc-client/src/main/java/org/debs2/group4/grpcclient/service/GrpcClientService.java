package org.debs2.group4.grpcclient.service;

import com.google.protobuf.Empty;
import de.tum.i13.bandency.Batch;
import de.tum.i13.bandency.Benchmark;
import de.tum.i13.bandency.BenchmarkConfiguration;
import de.tum.i13.bandency.ChallengerGrpc.ChallengerBlockingStub;
import de.tum.i13.bandency.ResultQ1;
import de.tum.i13.bandency.ResultQ2;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GrpcClientService {

    @GrpcClient("debs-grpc-server")
    private ChallengerBlockingStub stub;

    public String createNewBenchmark() {
        final Benchmark benchmark = stub.createNewBenchmark(
            BenchmarkConfiguration.newBuilder()
                                  .setToken("token")
                                  .setBenchmarkName("benchmark_name")
                                  .setBenchmarkType("test")
                                  .addAllQueries(DummyUtil.getQueryList())
                                  .build()
        );
        return benchmark.toString();
    }

    public String startBenchmark() {
        final Empty empty = stub.startBenchmark(
            Benchmark.newBuilder()
                     .setId(1L)
                     .build()
        );
        return empty.toString();
    }

    public String nextBatch() {
        final Batch batch = stub.nextBatch(
            Benchmark.newBuilder()
                     .setId(1L)
                     .build()
        );
        return batch.toString();
    }

    public String resultQ1() {
        final Empty empty = stub.resultQ1(
            ResultQ1.newBuilder()
                    .setBenchmarkId(1L)
                    .setBatchSeqId(1L)
                    .addAllIndicators(DummyUtil.getIndicatorList())
                    .build()
        );
        return empty.toString();
    }

    public String resultQ2() {
        final Empty empty = stub.resultQ2(
            ResultQ2.newBuilder()
                    .setBenchmarkId(1L)
                    .setBatchSeqId(1L)
                    .addAllCrossoverEvents(DummyUtil.getCrossoverEventList())
                    .build()
        );
        return empty.toString();
    }

    public String endBenchmark() {
        final Empty empty = stub.endBenchmark(
            Benchmark.newBuilder()
                     .setId(1L)
                     .build()
        );
        return empty.toString();
    }
}
