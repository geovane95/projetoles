package projetoles.nucleo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class converterData {

    public static String UtilToString(Date utilDate) {
        SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
        return formatBra.format(utilDate);
    }

    public static Date StringToUtil(String strDate) {
        if (strDate == null || strDate.equals(""))
            return null;

        Date date;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(strDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date UtilToSql (Date utilDate){
        java.sql.Date sqlDate;

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            utilDate = formatter.parse(UtilToString(utilDate));
            sqlDate = new java.sql.Date(utilDate.getTime());
            return sqlDate;
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }

    public static Date SqlToUtil(java.sql.Date sqlDate) {

        Date utilDate;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            utilDate = formatter.parse(sqlDate.toString());
            utilDate = StringToUtil(utilDate.toString());
            return utilDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }
    public static Date TimestampToUtil(java.sql.Timestamp tmpDate) {

        Date utilDate;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            utilDate = formatter.parse(tmpDate.toString());
            return utilDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static java.sql.Timestamp UtilToTimestamp (Date utilDate){
        java.sql.Timestamp tmpDate;

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            utilDate = formatter.parse(UtilToString(utilDate));
            tmpDate = new java.sql.Timestamp(utilDate.getTime());
            return tmpDate;
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }
}
