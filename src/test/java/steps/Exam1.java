package steps;

import common.BaseTest;
import io.cucumber.java.en.Given;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Exam1 extends BaseTest {

    private static final Logger logger = LogManager.getLogger(Exam1.class);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);

    @Given("Calculator between {string} and {string}")
    public void calculatorBetweenAnd(String arg0, String arg1) throws ParseException {
        logger.log(NOTICE, verifyStringIsValidDate(arg0));
        logger.log(NOTICE, verifyStringIsValidDate(arg1));
        Date firstDate = sdf.parse(arg0);
        Date secondDate = sdf.parse(arg1);
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        logger.info("Day between:" + diff);
    }

    @Given("Calculator close date when add {int} month into {string}")
    public void calculatorCloseDateWhenAddMonthInto(int arg0, String arg1) throws ParseException {
        logger.log(NOTICE, verifyStringIsValidDate(arg1));
        Date incrementedDate = DateUtils.addMonths(sdf.parse(arg1), arg0);
        logger.info("Close date:" + sdf.format(incrementedDate));
    }

}
