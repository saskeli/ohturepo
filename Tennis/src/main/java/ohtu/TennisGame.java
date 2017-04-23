package ohtu;

public class TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    
    private int m_score1 = LOVE;
    private int m_score2 = LOVE;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = equalScore();
        } else if (m_score1 > FORTY || m_score2 > FORTY) {
            score = tiebreaker();
        } else {
            score = scoreString(m_score1) + "-" + scoreString(m_score2);
        }
        return score;
    }

    private String equalScore() {
        switch (m_score1) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String tiebreaker() {
        int differense = m_score1 - m_score2;
        if (differense == 1) {
            return "Advantage player1";
        } else if (differense == -1) {
            return "Advantage player2";
        } else if (differense > 1) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String scoreString(int m_score) {
        switch (m_score) {
            case LOVE:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
