package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    private HasAtLeast hasAtLeast;

    public HasFewerThan(int value, String property) {
        hasAtLeast = new HasAtLeast(value, property);
    }
    
    @Override
    public boolean matches(Player p) {
        return !hasAtLeast.matches(p);
    }
    
}
