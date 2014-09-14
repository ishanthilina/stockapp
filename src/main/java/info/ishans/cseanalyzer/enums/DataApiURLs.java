package info.ishans.cseanalyzer.enums;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DataApiURLs {

    TRADE_SUMMARY_URL("http://www.cse.lk/trade_summary_report.do?reportType=CSV"),
    MARKET_CAPITAL_REPORT_URL("http://www.cse.lk/marketcap_report.do?reportType=CSV")
    ;

    private final String text;

    /**
     * @param text
     */
    private DataApiURLs(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
