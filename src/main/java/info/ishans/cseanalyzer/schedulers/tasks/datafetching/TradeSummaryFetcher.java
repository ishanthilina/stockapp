package info.ishans.cseanalyzer.schedulers.tasks.datafetching;

import info.ishans.cseanalyzer.data.BulkDataWriter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TradeSummaryFetcher extends URLDataFetcher {

    private BulkDataWriter dataWriter;

    public TradeSummaryFetcher(String url, BulkDataWriter dataWriter) {
        super(url);
        this.dataWriter = dataWriter;
    }

    @Override
    public void runTask() {

        File file=new File(new Date().toString());
        URL cseUrl= null;
        try {
            cseUrl = new URL(url);

            FileUtils.copyURLToFile(cseUrl, file);
            FileReader csvFileReader=new FileReader(file);

            dataWriter.writeTradeSummaryCSVToDB(csvFileReader);

        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
