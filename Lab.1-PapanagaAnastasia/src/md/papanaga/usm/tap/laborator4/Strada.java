package md.papanaga.usm.tap.laborator4;

import java.util.List;

public class Strada {
    String numeleStrazii;
    List<BlocLocativ> blocuriLocative;

    public Strada() {
    }

    public Strada(String numeleStrazii, List<BlocLocativ> blocuriLocative) {
        this.numeleStrazii = numeleStrazii;
        this.blocuriLocative = blocuriLocative;
    }

    public String getNumeleStrazii() {
        return numeleStrazii;
    }

    public void setNumeleStrazii(String numeleStrazii) {
        this.numeleStrazii = numeleStrazii;
    }

    public List<BlocLocativ> getBlocuriLocative() {
        return blocuriLocative;
    }

    public void setBlocuriLocative(List<BlocLocativ> blocuriLocative) {
        this.blocuriLocative = blocuriLocative;
    }

    @Override
    public String toString() {
        return "  "+numeleStrazii;
    }


}
