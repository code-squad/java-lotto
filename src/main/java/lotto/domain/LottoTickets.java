package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> selfSelectTickets;
    private final List<LottoTicket> autoSelectTickets;

    public LottoTickets(List<LottoTicket> selfSelectTickets, List<LottoTicket> autoSelectTickets) {
        this.selfSelectTickets = selfSelectTickets;
        this.autoSelectTickets = autoSelectTickets;
    }

    public int getSelfCount() {
        return selfSelectTickets.size();
    }

    public int getAutoCount() {
        return autoSelectTickets.size();
    }

    public List<LottoTicket> getAllTickets() {
        return Stream.concat(selfSelectTickets.stream(), autoSelectTickets.stream())
                .collect(Collectors.toList());
    }

    public int getSize() {
        return selfSelectTickets.size() + autoSelectTickets.size();
    }
}
