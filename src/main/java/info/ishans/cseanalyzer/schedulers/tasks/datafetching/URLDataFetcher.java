package info.ishans.cseanalyzer.schedulers.tasks.datafetching;

import info.ishans.cseanalyzer.schedulers.tasks.CseAnalyzerTask;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class URLDataFetcher implements CseAnalyzerTask{

    protected URLDataFetcher(String url) {
        this.url = url;
    }

    protected String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
