package info.ishans.cseanalyzer.schedulers;

import info.ishans.cseanalyzer.data.BulkDataWriter;
import info.ishans.cseanalyzer.enums.DataApiURLs;
import info.ishans.cseanalyzer.schedulers.tasks.datafetching.TradeSummaryFetcher;
import info.ishans.cseanalyzer.schedulers.tasks.datafetching.URLDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataImportScheduler {

    @Autowired
    @Qualifier("bulkDataWriter")
    private BulkDataWriter dataWriter;

    @Scheduled(cron = "0 30 22 * * *",zone = "Asia/Colombo")
    public void runTasks(){

        System.out.println("Starting");
        URLDataFetcher tradeSummaryFetcher=new TradeSummaryFetcher(DataApiURLs.TRADE_SUMMARY_URL.toString(), dataWriter);
        tradeSummaryFetcher.runTask();
        System.out.println("ran");
    }
}
