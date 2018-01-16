/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.utilities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Dátumot kezelő, beállító és konvertáló metódusok.
 *
 * @author Varsányi Péter
 * @since Richard Szabo : add two methods 2017.05.03
 */
public class DateUtility {

    /**
     * A megadott dátumhoz tartozó nap neve.
     *
     * @param date Dátum.
     * @return A nap teljes neve.
     */
    public static String getDayName( Temporal date ) {
        return LocalDate.from(date).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    /**
     * Dátum formázott stringként.
     *
     * @param date Dátum.
     * @return A dátum stringként.
     */
    public static String getFormattedDateStr( Temporal date ) {
        if ( date == null ) {
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Utility.getI18nFormats("format.date"));
        return LocalDate.from(date).format(dtf);
    }

    /**
     * A megadott dátum valid-e, nagyobb-e mint a most.
     *
     * @param date Vizsgált dátum.
     * @return Boolean.
     */
    public static Boolean isValidDate( LocalDateTime date ) {
        return date.isAfter(LocalDateTime.now());
    }

    /**
     * A validTo mező értéke.
     *
     * @return LocalDateTime típusú dátum.
     */
    public static LocalDateTime getValidToDate() {
        return LocalDateTime.of(2100, 1, 1, 0, 0, 0);
    }

    /**
     * Dátum és idő formázott stringként.
     *
     * @param date Dátum.
     * @return A dátum és idő stringként.
     */
    public static String getFormattedDatetimeStr( LocalDateTime date ) {
        if ( date == null ) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(Utility.getI18nFormats("format.datetime")));
    }

    /**
     * Idő formázott stringként.
     *
     * @param time Idő.
     * @return A dátum és idő stringként.
     */
    public static String getFormattedTimeStr( LocalTime time ) {
        if ( time == null ) {
            return null;
        }
        return time.format(DateTimeFormatter.ofPattern(Utility.getI18nFormats("format.time")));
    }


    /**
     * Dátum (<code>Date</code>) típus átalakítása/konvertálása
     * <code>LocalDate</code> típussá.
     *
     * @param date Input dátum.
     * @return A dátum <code>LocalDate</code>-ként.
     */
    public static LocalDate getLocalDate( Date date ) {
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    /**
     * A paraméter Temporal típust kovertálja LocalDate típusra
     *
     * @param date
     * @return
     */
    public static LocalDate getLocalDate( Temporal date ) {
        return LocalDate.from(date);
    }

    /**
     * A paraméter Temporal típust kovertálja LocalDateTime típusra
     *
     * @param date
     * @return
     */
    public static LocalDateTime getLocalDateTime( Temporal date ) {
        if ( date instanceof LocalDate ) return LocalDateTime.from(((LocalDate) date).atStartOfDay());
        return LocalDateTime.from(date);
    }

    public static LocalTime getLocalTime(Date date ) {
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime() : null;
    }

    /**
     * <code>LocalDate</code> dátum típus átalakítása/konvertálása
     * <code>Date</code> típussá.
     *
     * @param localDate LocalDate instance. Nem lehet null!
     * @return A dátum <code>Date</code>-ként.
     */
    public static Date getDate( Temporal localDate ) {
        if ( localDate == null ) {
            return null;
        }
        LocalDateTime localDateTime;
        if ( localDate instanceof LocalDate ) {
            localDateTime = ((LocalDate) localDate).atStartOfDay();
        } else {
            localDateTime = (LocalDateTime) localDate;
        }
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Date getDate( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * Dátum (<code>Date</code>) típus átalakítása/konvertálása
     * <code>Date</code> típussá.
     *
     * @param date Input dátum.
     * @return A dátum <code>Date</code>-ként.
     */
    public static LocalDateTime getLocalDateTime( Date date ) {
        if ( date == null ) return null;
        Date javaUtilDate = new Date(date.getTime());
        return javaUtilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Az aktuális dátum hónapjának első napja a kalendáriumnak. A kalendárium
     * mindig hétfőtől - vasárnapig jeleníti meg a napokat. Ha egy hónap nem
     * hétfővel kezdődik, akkor kitolja azt az eleje előtti legközelebbi
     * hétfőig.
     *
     * @param date Date
     * @return Az aktuális dátum hónapjának első napja, ha hétfő. Ha nem, akkor
     * az első nap előtti legleső hétfő. Az idő a nap elejére állítva.
     */

    public static LocalDateTime getMonthStartDateForCalendar( Temporal date ) {
        return getWeekStartDateForCalendar(getStartDayOfMonth(date));
    }

    /**
     * Az aktuális dátum hónapjának utolsó napja a kalendáriumnak. A kalendárium
     * mindig hétfőtől - vasárnapig jeleníti meg a napokat. Ha egy hónap nem
     * vasárnap végződik, akkor kitolja azt a vége utáni legközelebbi
     * vasárnapig.
     *
     * @return Az aktuális dátum hónapjának utolsó napja, ha vasárnap. Ha nem,
     * akkor az utolsó nap utáni legleső vasárnap. Az idő a nap végére állítva.
     */
    public static LocalDateTime getMonthEndDateForCalendar( Temporal date ) {
        return getWeekEndDateForCalendar(getEndDayOfMonth(date));
    }

    /**
     * Az aktuális dátum hónapjának utolsó napja.
     *
     * @return Az aktuális dátum hónapjának utolsó napja, az idő a nap végére
     * állítva.
     */
    public static LocalDateTime getMonthEndDateForCalendar() {
        return getMonthEndDateForCalendar(LocalDateTime.now());
    }

    /**
     * Az aktuális dátum hetének első napja.
     *
     * @return Az aktuális dátum hetének első napja, az idő a nap elejére
     * állítva.
     */
    public static LocalDateTime getWeekStartDateForCalendar() {
        return getWeekStartDateForCalendar(LocalDateTime.now());
    }

    public static LocalDateTime getWeekStartDateForCalendar( Temporal date ) {
        if ( date == null ) return null;
        TemporalField dayOfWeek = WeekFields.of(Utility.getDefaultLocale()).dayOfWeek();
        return LocalDateTime.from(setTimePartToStartOfDay(date)).with(dayOfWeek, 1);
    }

    /**
     * Az aktuális dátum hetének utolsó napja.
     *
     * @return Az aktuális dátum hetének utolsó napja, az idő a nap végére
     * állítva.
     */
    public static LocalDateTime getWeekEndDateForCalendar() {
        return getWeekEndDateForCalendar(LocalDateTime.now());
    }

    public static LocalDateTime getWeekEndDateForCalendar( Temporal date ) {
        if ( date == null ) return null;
        TemporalField dayOfWeek = WeekFields.of(Utility.getDefaultLocale()).dayOfWeek();
        return LocalDateTime.from(setTimePartToEndOfDay(date)).with(dayOfWeek, 7);
    }

    /**
     * Az aktuális dátum-nap kezdete.
     *
     * @return A megadott dátum 0:0:0 idővel.
     */
    public static LocalDateTime getDayStartDateForCalendar() {
        return getStartOfDay(LocalDateTime.now());
    }

    /**
     * Az aktuális dátum-nap vége.
     *
     * @return A megadott dátum 23:59:59 idővel.
     */
    public static LocalDateTime getDayEndDateForCalendar() {
        return getEndOfDay(LocalDateTime.now());
    }

    /**
     * A hónap első napja. Az idő részt (óra, perc, mp) a nap legelejére
     * állítja.
     *
     * @param date A megadott dátum.
     * @return A megadott dátum hónapjának első napját (elsejét) állítja be.
     */
    public static LocalDateTime getStartDayOfMonth( Temporal date ) {
        return LocalDateTime.from(setTimePartToStartOfDay(date)).withDayOfMonth(1);
    }

    /**
     * A nap kezdete. Az idő részt (óra, perc, mp) a nap legelejére állítja.
     *
     * @param date A megadott dátum.
     * @return A megadott dátum 0:0:0 idővel.
     */
    public static LocalDateTime getStartOfDay( Temporal date ) {
        return LocalDateTime.from(setTimePartToStartOfDay(date));
    }

    /**
     * A hónap utolsó napja. Az idő részt (óra, perc, mp) a nap legvégére
     * állítja.
     *
     * @param date A megadott dátum.
     * @return A megadott dátum hónapjának utolsó napját állítja be.
     */
    public static LocalDateTime getEndDayOfMonth( Temporal date ) {
        return LocalDateTime.from(setTimePartToEndOfDay(date)).withDayOfMonth(LocalDate.from(date).lengthOfMonth());
    }

    /**
     * A nap vége. Az idő részt (óra, perc, mp) a nap legvégére állítja.
     *
     * @param date A megadott dátum.
     * @return A megadott dátum 23:59:59 idővel.
     */
    public static LocalDateTime getEndOfDay( Temporal date ) {
        return LocalDateTime.from(setTimePartToEndOfDay(date));
    }

    /**
     * Az év kezdete.
     *
     * @param year A megadott év.
     * @return Az év kezdete perc pontossággal.
     */
    public static LocalDateTime getStartOfYear( int year ) {
        return setTimePartToStartOfDay(LocalDate.of(year, 1, 1));
    }

    /**
     * Az év vége.
     *
     * @param year A megadott év.
     * @return Az év vége perc pontossággal.
     */
    public static LocalDateTime getEndOfYear( int year ) {
        return setTimePartToEndOfDay(LocalDate.of(year, 12, 31));
    }

    /**
     * A megadott két dátum közötti teljes hónap eslő napját adja vissza. Ha
     * nincs meg egy teljes hónap, akkor a start date-et adja vissza. Ha
     * valmelyik dátum null, akkor nullal tér vissza.
     *
     * @param start Az időszak kezdete.
     * @param end   Az időszak vége.
     * @return Null vagy dátum.
     */
    public static LocalDateTime getFullMonthFirstDay( Temporal start, Temporal end ) {
        // ha valamelyik null, akkor return null
        if ( start == null || end == null ) return null;

        LocalDate startDate = LocalDate.from(start);
        LocalDate endDate = LocalDate.from(end);

        // a korábbi az end, mint a start vagy egyenlő a kettő, akkor return start
        if ( startDate.isAfter(endDate) || startDate.isEqual(endDate) ) {
            return LocalDateTime.from(startDate.atStartOfDay());
        }

        // teljes hónap keresése
        // első nap
        LocalDate startDateForStart = LocalDate.from(getStartDayOfMonth(start)); // kalkulált hónap első napja

        // ha a megadott kezdődátum nem a hónap első napja akkor a teljes hónap már csak a következő hónap lehet
        if ( startDate.getDayOfMonth() != 1 ) {
            startDateForStart = startDateForStart.plusMonths(1);
        }

        LocalDate endDateForStart = LocalDate.from(getEndDayOfMonth(start));

        // ha a vége paraméter kisebb mint a kalkulált startdate-hez tartozó hónap utolsó napja, akkor nincs meg a tejles hónap
        if ( endDate.isBefore(endDateForStart) ) return LocalDateTime.from(startDate.atStartOfDay());

        return LocalDateTime.from(startDateForStart.atStartOfDay());
    }

    /**
     * Kinullázza megadott dátum összes idő mezőjét (00:00:00.000)
     *
     * @param date
     * @return
     */
    public static LocalDateTime setTimePartToStartOfDay( Temporal date ) {
        return LocalDate.from(date).atStartOfDay();
    }

    /**
     * Kinullázza megadott dátum összes idő mezőjét (00:00:00.000)
     *
     * @param date
     * @return
     */
    public static LocalDateTime setTimePartToEndOfDay( Temporal date ) {
        return LocalDate.from(date).atTime(23, 59, 59);
    }

    /**
     * Két dátum között eltelt éjszakák száma.
     *
     * @param startDate Az intervallum kezdete. Nem lehet null és későbbi, mint
     *                  a vége!
     * @param endDate   Az intervallum vége. Nem lehet null és korábbi, mint a
     *                  kezdete!
     * @return Az eltelt éjszakák száma.
     */
    public static long getNights( Temporal startDate, Temporal endDate ) {

        if ( startDate == null || endDate == null ) {
            return -1;
        }

        LocalDate start = LocalDate.from(startDate);
        LocalDate end = LocalDate.from(endDate);

        if ( start.isAfter(end) ) {
            return -1;
        }

        if ( start.isEqual(end) ) {
            return 0;
        }

        return getNightsDays(startDate, endDate).size();
    }

    /**
     * Két dátum között eltelt éjszakák napjai.
     *
     * @param startDate Az intervallum kezdete. Nem lehet null és későbbi, mint
     *                  a vége!
     * @param endDate   Az intervallum vége. Nem lehet null és korábbi, mint a
     *                  kezdete!
     * @return Az eltelt napok listája. Ha valami nem stimmelt, akkor üres.
     */
    public static List<LocalDate> getNightsDays( Temporal startDate, Temporal endDate ) {
        List<LocalDate> dateList = new ArrayList<>();

        LocalDate end = LocalDate.from(endDate);

        for ( LocalDate start = LocalDate.from(startDate); start.isBefore(end); start = start.plus(1, ChronoUnit.DAYS) ) {
            dateList.add(LocalDate.from(start));
        }

        return dateList;
    }

    /**
     * A dátum stringként és utána zárójelben a nap neve.
     *
     * @param date A dátum.
     *             r6tuhrts* @return A dátum stringként és utána zárójelben a nap neve.
     */
    public static String getDateAndDayName( LocalDate date ) {
        if ( date == null ) {
            return "";
        }
        return getFormattedDateStr(date) + " (" + getDayName(date) + ")";
    }

    /**
     * @param endDate : Date
     * @return boolean
     * @parjram startDate : Date
     */
    public static boolean isSameDay( final Temporal startDate, final Temporal endDate ) {
        if ( endDate != null && startDate != null ) {
            return LocalDate.from(startDate).isEqual(LocalDate.from(endDate));
        }
        return false;
    }

    /**
     * A date növelése mértékegység megadásával
     *
     * @param thatDate      Amit növelni kell
     * @param calendarField A Calnedar típusban meghatározott mező azonosító (pl.: Calendar.DAY_OF_YEAR)
     * @param n             A növekmény mértéke
     * @return LocalDateTime A megnövelt dátumot adja vissza
     */
    public static LocalDateTime addToDate( final Temporal thatDate, int n, ChronoUnit chronoUnit ) {
        return LocalDateTime.from(thatDate).plus(n, chronoUnit);
    }

    /**
     * @param thatDate : A dátum amihez hozzá akarsz adni órát
     * @param n        : órák száma
     * @return Date
     */
    public static LocalDateTime addHoursToDate( final Temporal thatDate, final int n ) {
        return addToDate(thatDate, n, ChronoUnit.HOURS);
    }

    /**
     * @param thatDate : A LocalDateTime amihez hozzá akarsz adni napot
     * @param n        : napok száma
     * @return Date
     */
    public static LocalDateTime addDaysToDate( final Temporal thatDate, final int n ) {
        return addToDate(thatDate, n, ChronoUnit.DAYS);
    }

    /**
     * @param thatDate : A LocalDateTime amihez hozzá akarsz adni heteket
     * @param n        : hetek száma
     * @return Date
     */
    public static LocalDateTime addWeeksToDate( final Temporal thatDate, final int n ) {
        return addToDate(thatDate, n, ChronoUnit.WEEKS);
    }

    /**
     * @param thatDate : A LocalDateTime amihez hozzá akarsz adni hónapot
     * @param n        : hónapok száma
     * @return Date
     */
    public static LocalDateTime addMonthsToDate( final Temporal thatDate, final int n ) {
        return addToDate(thatDate, n, ChronoUnit.MONTHS);
    }

    /**
     * @param thatDate : A LocalDateTime amihez hozzá akarsz adni éveket
     * @param n        : napok száma
     * @return Date
     */
    public static LocalDateTime addYearsToDate( final Temporal thatDate, final int n ) {
        return addToDate(thatDate, n, ChronoUnit.YEARS);
    }

}
