package org.debs2.group4.grpcclient.service;

import com.google.protobuf.Timestamp;
import de.tum.i13.bandency.CrossoverEvent;
import de.tum.i13.bandency.CrossoverEvent.SignalType;
import de.tum.i13.bandency.Indicator;
import de.tum.i13.bandency.Query;
import de.tum.i13.bandency.SecurityType;
import java.util.List;

public final class DummyUtil {

    private DummyUtil() {
    }

    public static List<Query> getQueryList() {
        return List.of(Query.Q1, Query.Q2);
    }

    public static List<Indicator> getIndicatorList() {
        return List.of(
            Indicator.newBuilder()
                     .setSymbol("symbol_1")
                     .setEma38(1.0f)
                     .setEma100(2.0f)
                     .build(),
            Indicator.newBuilder()
                     .setSymbol("symbol_2")
                     .setEma38(1.1f)
                     .setEma100(2.2f)
                     .build()
        );
    }

    public static List<CrossoverEvent> getCrossoverEventList() {
        return List.of(
            CrossoverEvent.newBuilder()
                          .setTs(Timestamp.getDefaultInstance())
                          .setSymbol("symbol_1")
                          .setSecurityType(SecurityType.Index)
                          .setSignalType(SignalType.Buy)
                          .build(),
            CrossoverEvent.newBuilder()
                          .setTs(Timestamp.getDefaultInstance())
                          .setSymbol("symbol_2")
                          .setSecurityType(SecurityType.Index)
                          .setSignalType(SignalType.Buy)
                          .build()
        );
    }
}
