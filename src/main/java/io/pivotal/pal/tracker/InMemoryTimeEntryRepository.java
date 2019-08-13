package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    HashMap<Long, TimeEntry> repository = new HashMap<>();
    long counter = 1;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry timeEntry1 = new TimeEntry(counter,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());
        repository.put(counter,timeEntry1);
        counter++;
        return timeEntry1;
    }

    public TimeEntry find(long id) {
        return repository.get(id);
    }


    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(find(id)==null) return null;
        TimeEntry timeEntryUpdated = new TimeEntry(id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());
        repository.replace(id,timeEntryUpdated);
        return  timeEntryUpdated;
    }

    public void delete(long id) {
        repository.remove(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(repository.values());
    }
}
