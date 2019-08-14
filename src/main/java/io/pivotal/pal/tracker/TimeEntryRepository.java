package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry any) ;

    public TimeEntry find(Long timeEntryId) ;

    List<TimeEntry> list();

    TimeEntry update(Long eq, TimeEntry any);

    void delete(Long timeEntryId);

    void setup();
}
