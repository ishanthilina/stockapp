package info.ishans.cseanalyzer.data;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class BulkDataWriter {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void writeTradeSummaryCSVToDB(FileReader csvFileReader){

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            CopyManager copyManager = new CopyManager((BaseConnection) conn);

            copyManager.copyIn("COPY trade_summary FROM STDIN USING DELIMITERS ',' CSV HEADER", csvFileReader );

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

}
