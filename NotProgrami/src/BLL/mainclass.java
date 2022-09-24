package BLL;

public class mainclass {

    public char yesMiNoMu(byte veri) {
        if (veri == 1) {
            return 'E';
        } else {
            return 'H';
        }

    }

    static public void mesaj(String msg) {
        System.out.println(msg);
    }

    /*  static public String bossa(String veri){
        return veri ;
    }*/
    static public boolean isEB(String data) {
        if (!data.isBlank() && !data.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean dogrumu(byte veri) {

        return veri == 1;
    }

    public char durum(byte veri) {
        if (veri == 1) {
            return 'A';
        } else {
            return 'P';
        }
    }

    public String nottype(int type) {
        switch (type) {
            case 1:
                return "Not";
            case 2:
                return "Yap";
            case 3:
                return "Hatırla";
            default:
                return "Rutin";
        }

    }
}
