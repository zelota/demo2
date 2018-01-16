/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Művelet eredményét tartalmazó objektum.
 *
 * @author Varsányi Péter
 * @since 2017.07.21 - varp = egyétleműbb elírás + getMessages módosítása.
 */
public class ActionResult<T> implements Serializable {

    private static final long serialVersionUID = 20160707122534535L;

    private Boolean ok = false;
    private List<String> messages = new ArrayList<>();
    private Exception exception = null;
    private List<T> items = new ArrayList<>();

    public ActionResult() {
    }

    public ActionResult( Boolean ok ) {
        this.ok = ok;
    }

    public ActionResult( Boolean ok, String message ) {
        this.ok = ok;
        this.messages.add(message);
    }

    public ActionResult( Boolean ok, List<T> items ) {
        this.ok = ok;
        this.items.addAll(items);
    }

    public ActionResult( Boolean ok, T item ) {
        this.ok = ok;
        this.items.add(item);
    }

    public ActionResult( Boolean ok, String message, T item ) {
        this.ok = ok;
        this.items.add(item);
        this.messages.add(message);
    }

    public ActionResult( Exception ex ) {
        this.ok = false;
        this.exception = ex;
    }

    /**
     * Hibaüzenet. Ha több van összefűzi egy üzenetté. Ha exception van, akkor
     * annak az üzenetét is kiveszi. Ha vannak üzenetek és exception is, az
     * exception üzenetét nem adja hozzá az eredményhez! (Mert nagy
     * valószínűséggel, már ott van már az is.)
     *
     * @return összefűzött üzenetek.
     */
    public String getMessage() {
        StringBuilder retVal = new StringBuilder();
        if ( !this.messages.isEmpty() ) {
            for ( String s : this.messages ) {
                retVal.append(s).append(" ");
            }
        }
        if ( this.exception != null && this.messages.isEmpty() ) {
            retVal = new StringBuilder(this.exception.getMessage());
        }
        return retVal.toString();
    }

    /**
     * Üzenetek. Ha nincs egyetlen üzenet sem, csak exception, akkor azt is
     * visszaadja. Ha vannak üzenetek és exception is, akkor csak az üzeneteket
     * adja vissza!
     *
     * @return Üzenetek, az exception üzenetet is beleértve.
     */
    public List<String> getMessages() {
        if ( this.messages == null ) {
            this.messages = new ArrayList<>();
        }
        if ( this.messages.isEmpty() && this.exception != null ) {
            this.messages.add(getMessage());
        }
        return messages;
    }

    /**
     * Üzenetek beállítása. Az oké flag-et is beállítja, attól függően, h van-e
     * vagy nincs üzenet.
     *
     * @param messages Üzenetek lista vagy null.
     */
    public ActionResult<T> setMessages( List<String> messages ) {
        this.ok = !(messages != null && !messages.isEmpty());
        this.messages = messages;
        return this;
    }

    /**
     * Üzenet hozzáadása. Az ok-ot false-ra állítja!
     *
     * @param messages Az üzenet szövege.
     */
    public ActionResult<T> addMessage( String messages ) {
        this.ok = false;
        this.messages.add(messages);
        return this;
    }

    /**
     * Üzenet lista hozzáadása. Az ok-ot false-ra állítja ha a lista nem üres!
     *
     * @param messages Az üzenet szövege.
     */
    public ActionResult<T> addMessages( List<String> messages ) {
        if ( !messages.isEmpty() ) {
            this.ok = false;
        }
        this.messages.addAll(messages);
        return this;
    }

    public Exception getException() {
        return exception;
    }

    public ActionResult<T> setException( Exception exception ) {
        this.exception = exception;
        return this;
    }

    public List<T> getItems() {
        return items;
    }

    public ActionResult<T> setItems( List<T> items ) {
        this.items = items;
        return this;
    }

    public ActionResult<T> addItem( T item ) {
        this.items.add(item);
        return this;
    }

    public T getItem() {
        if ( this.items.isEmpty() ) {
            return null;
        }
        if ( this.items.size() == 1 ) {
            return this.items.get(0);
        }
        throw new UnsupportedOperationException("There are more than one objects in items property! Use getItems()! ");
    }

    public ActionResult<T> setItem( T item ) {
        this.items.clear();
        this.items.add(item);
        return this;
    }

    public Boolean isOk() {
        return this.ok;
    }

    public ActionResult<T> setOk( Boolean ok ) {
        this.ok = ok;
        return this;
    }

    /**
     * Ha exception van vagy üzenetek, akkor igaz.
     *
     * @return Ha exception van vagy üzenetek, akkor igaz.
     */
    public Boolean hasError() {
        return this.exception != null || !this.messages.isEmpty();
    }

    /**
     * A castolandó exception jellemzőinek átvétele. A különböző típusúak miatt
     * kell ez. Ha pl egy service-ben több másik service-t is hívunk, és az
     * egyik lépés eredménye hiba, de a típusa nem egyezik meg a hívó service
     * típusával. Akkor ezzel a methoddal adhatjuk át a releváns adatok/az
     * eredményt.
     * <p>
     * Ezeket veszi át:
     * <ul>
     * <li>exception</li>
     * <li>messages</li>
     * <li>ok</li>
     * </ul>
     *
     * @param otherResult Az átveendő/másolandó result objektum.
     */
    @SuppressWarnings("unchecked")
    public void cast( ActionResult otherResult ) {
        this.messages.clear();
        this.exception = null;
        this.items.clear();

        this.exception = otherResult.getException();
        this.messages = otherResult.getMessages();
        this.ok = otherResult.isOk();
    }

}
