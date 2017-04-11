package enums;

/**
 * @author Anton Koksharov
 *         Date: 10.08.2016
 */
public enum PurchaseType {
    CONTEST("Конкурс", "11011"),
    AUCTION("Аукцион", "12012"),
    SINGE_SUPPLIER("Закупка у единственного поставщика (подрядчика, исполнителя)", "30000"),
    ANOTHER("Иной способ закупки, предусмотренный правовым актом заказчика, указанным в части 1 статьи 2 Федерального закона", "40000");

    private String title;
    private String code;

    PurchaseType(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public String getName(){
        return this.name();
    }

    public String getCode() {
        return code;
    }

    public static PurchaseType valueByCode(String code) {
        if (CONTEST.getCode().equals(code)) {
            return CONTEST;
        } else if (AUCTION.getCode().equals(code)) {
            return AUCTION;
        } else if (SINGE_SUPPLIER.getCode().equals(code)) {
            return SINGE_SUPPLIER;
        } else if (ANOTHER.getCode().equals(code)) {
            return ANOTHER;
        } else return null;
    }
}
