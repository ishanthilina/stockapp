package info.ishans.cseanalyzer.controllers;

import info.ishans.cseanalyzer.data.BulkDataWriter;
import info.ishans.cseanalyzer.enums.DataApiURLs;
import info.ishans.cseanalyzer.schedulers.tasks.datafetching.TradeSummaryFetcher;
import info.ishans.cseanalyzer.schedulers.tasks.datafetching.URLDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    @Qualifier("bulkDataWriter")
    private BulkDataWriter dataWriter;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "adminpage";
    }

    @RequestMapping(value = "/manualdataimport/tradesummary",method = RequestMethod.GET)
    public String manualFetchTradeSummary(ModelMap model) {

        URLDataFetcher tradeSummaryFetcher=new TradeSummaryFetcher(DataApiURLs.TRADE_SUMMARY_URL.toString(), dataWriter);
        tradeSummaryFetcher.runTask();

        model.addAttribute("message", "Trade Summary upload successfull!");
        return "adminpage";
    }
}
