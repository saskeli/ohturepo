package statistics.matcher;

import java.util.*;

public class QueryBuilder {

    List<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList<>();
    }

    public Matcher build() {
        Matcher ret = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return ret;
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String property) {
        matchers.add(new HasFewerThan(value, property));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String property) {
        matchers.add(new HasAtLeast(value, property));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        if (matchers.length < 1) {
            return this;
        } else if (matchers.length == 1) {
            this.matchers.add(matchers[0]);
        } else {
            this.matchers.add(new Or(matchers));
        }
        return this;
    }
}
