/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.abstracts;

import demo2common.utilities.TextUtility;

import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 10. 02.
 */
public abstract class AbstractOrganization extends AbstractBaseEntity {

    public abstract String getMaterPath();

    /**
     * A gyerek elemek lekérdezésére használható mather path adja vissza.
     * Annyiva több, mint a <code>matherPath</code>, hogy egy pontot rak a végére.
     * Ha a <code>matherPath</code> <code>null</code>, akkor <code>null</code>-t ad vissza!
     *
     * @return Mater path a gyerekek lekérdezésére vagy <code>null</code>, ha a <code>matherPath</code> "értéke" <code>null</code>.
     */
    @XmlTransient
    public String getMaterPathForChildren() {
        return getMaterPathForParent() + ".";
    }

    /**
     * E szervezet gyökér szervezetétének (ami közvetlen az ASH alatt van) a materpath-át adja vissza.
     * Akár saját magát.
     *
     * @return Mather path vagy null.
     */
    @XmlTransient
    public String getMaterPathForParent() {
        List<Integer> indexes = TextUtility.allIndex(this.getMaterPath(), ".");
        if ( indexes.size() > 1 ) {
            return this.getMaterPath().substring(0, indexes.get(1));
        }
        return this.getMaterPath();
    }


}
