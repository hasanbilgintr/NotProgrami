package BLL;

import java.util.Date;
public class customers {

    /*kod düzenleme alt+şift +f */
    private int CUSTOMER;
    private String CUSTOMERNAME;

    public customers(int CUSTOMER, String CUSTOMERNAME) {
        this.CUSTOMER = CUSTOMER;
        this.CUSTOMERNAME = CUSTOMERNAME;
    }

    public int getCUSTOMER() {
        return CUSTOMER;
    }

    public void setCUSTOMER(int CUSTOMER) {
        this.CUSTOMER = CUSTOMER;
    }

    public String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }

    public void setCUSTOMERNAME(String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME;
    }
   

    
}
