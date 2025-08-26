import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DNIErrors {
    private final List<String> reasons = new ArrayList<>();

    public List<String> reasons() {
        return Collections.unmodifiableList(this.reasons);
    }

    public void add(String reason) {
        this.reasons.add(reason);
    }

    public boolean containsAny() {
        return !this.reasons.isEmpty();
    }
}
